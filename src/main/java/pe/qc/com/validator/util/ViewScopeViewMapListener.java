package pe.qc.com.validator.util;

import java.lang.ref.WeakReference;

import javax.faces.component.UIViewRoot;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PreDestroyViewMapEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.ViewMapListener;

/**
 * @author Michail Nikolaev ate: 21.11.12 Time: 0:37
 */
public class ViewScopeViewMapListener implements ViewMapListener {
    private String name;
    private Runnable callback;
    private boolean callbackCalled = false;
    private WeakReference<UIViewRoot> uiViewRootWeakReference;
    private ViewScope viewScope;

    public ViewScopeViewMapListener(UIViewRoot root, String name, Runnable callback, ViewScope viewScope) {
        this.name = name;
        this.callback = callback;
        this.uiViewRootWeakReference = new WeakReference<UIViewRoot>(root);
        this.viewScope = viewScope;
    }

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        if (event instanceof PreDestroyViewMapEvent) {
            doCallback();
            viewScope.clearFromListener(this);
        }
    }

    public boolean checkRoot() {
        if (uiViewRootWeakReference.get() == null) {
            doCallback();
            return true;
        }
        return false;
    }

    public synchronized void doCallback() {
        if (!callbackCalled) {
            try {
                callback.run();
            } finally {
                callbackCalled = true;
            }
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return (source == uiViewRootWeakReference.get());
    }
}
