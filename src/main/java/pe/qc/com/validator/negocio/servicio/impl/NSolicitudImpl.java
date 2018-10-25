package pe.qc.com.validator.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.qc.com.validator.negocio.bo.BOSolicitud;
import pe.qc.com.validator.negocio.servicio.NSolicitud;
import pe.qc.com.validator.persistencia.entity.BSolicitud;
import pe.qc.com.validator.persistencia.mapper.MSolicitud;
import pe.qc.com.validator.persistencia.mapper.MUsuario;
import pe.qc.com.validator.util.Constantes;
import pe.qc.com.validator.util.excepcion.aplicacion.NegocioExcepcion;
import pe.qc.com.validator.util.excepcion.aplicacion.PersistenciaExcepcion;
import pe.qc.com.validator.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NSolicitudImpl implements NSolicitud{
	
	@Autowired
	MSolicitud mSolicitud;
	@Autowired
	MUsuario mUsuario;
	
	@Autowired
	@Qualifier("tSolicitudEntityBO")
	TransformadorEntityBO<BSolicitud, BOSolicitud> transformador;
	
	@Override
	public List<BOSolicitud> listarSolicitud(Integer idUsuario) {
		List<BOSolicitud> listaSolicitud = new ArrayList<BOSolicitud>();
		try{
			listaSolicitud = transformador.toBO(mSolicitud.listarSolicitud(idUsuario));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaSolicitud;
	}
	
	@Override
	public List<BOSolicitud> listarSolicitudGeneral(Integer idRevisor) {
		List<BOSolicitud> listaSolicitud = new ArrayList<BOSolicitud>();
		try{
			listaSolicitud = transformador.toBO(mSolicitud.listarSolicitudGeneral(idRevisor));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e ){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaSolicitud;
	}
	
	@Override
	public BOSolicitud obtenerSolicitudXId(Integer id) {
		BOSolicitud Solicitud = null;
		try{
			Solicitud = transformador.toBO(mSolicitud.obtenerSolicitudXId(id));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Solicitud;
	}
	
	@Override
	public BOSolicitud obtenerSolicitudXnombreTk(String nombreTk) {
		BOSolicitud Solicitud = null;
		try{
			Solicitud = transformador.toBO(mSolicitud.obtenerSolicitudXnombreTk(nombreTk));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Solicitud;
	}
	
	@Override
	public BOSolicitud obtenerSolicitudXnombreTkPrimero(String nombreTk){
		BOSolicitud Solicitud = null;
		try{
			Solicitud = transformador.toBO(mSolicitud.obtenerSolicitudXnombreTkPrimero(nombreTk));
		}catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		}catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return Solicitud;
	}

	@Override
	public void insertarSolicitud(BOSolicitud Solicitud) {
		try {
			mSolicitud.insertarSolicitud(transformador.toEntity(Solicitud));
		} catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_INSERCION_REGISTRO, e);
		} catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}
	
	@Override
	public void modificarSolicitudTK(BOSolicitud Solicitud) {
		try {
			mSolicitud.modificarSolicitud(transformador.toEntity(Solicitud));
		} catch(PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_INSERCION_REGISTRO, e);
		} catch(Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}
	
	@Override
	public void modificarSolicitud(BOSolicitud Solicitud, Integer idSolicitud) {
		try {
			mSolicitud.convertirAHistoricoSolicitud(idSolicitud);
			Solicitud.setIdHistoricoSolicitud(idSolicitud);
			Solicitud.setFechaSolicitud(new java.util.Date());
			insertarSolicitud(Solicitud);
		} catch (PersistenciaExcepcion e){
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_MODIFICACION_REGISTRO, e);
		} catch (Exception e){
			throw new NegocioExcepcion(Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
	}
	
	@Override
	public List<Map<String, Object>> listarMapSolicitud() {
		List<Map<String, Object>> listaMapSolicitud = null;
		try {
			listaMapSolicitud = mSolicitud.listarMapSolicitud();
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaMapSolicitud;
	}
	
	@Override
	public List<Map<String, Object>> listarMapHistoricaSolicitud(Integer idSolicitud) {
		List<Map<String, Object>> listaMapHistoricaSolicitud = new ArrayList<Map<String, Object>>();
		Map<String, Object> solicitud = null;
		Integer idRevisor = null;
		try {
			if(idSolicitud!=0) {
				while (idSolicitud!=null) {
					String nombreRevisor = "";
					solicitud = mSolicitud.MapSolicitudxIdHistorico(idSolicitud);
					if(solicitud.get("idRevisor")!=null) {
						idRevisor = Integer.parseInt(String.valueOf(solicitud.get("idRevisor")));
						nombreRevisor = mUsuario.obtenerUsuarioXId(idRevisor).getNombreUsuario();
						solicitud.put("nombreRevisor", nombreRevisor);
					}else {
						solicitud.put("nombreRevisor", "-");
						solicitud.put("idRevisor", "-");
					}
					listaMapHistoricaSolicitud.add(solicitud);
					if(solicitud.get("idHistoricoSolicitud")!=null) {
						idSolicitud = Integer.parseInt(String.valueOf(solicitud.get("idHistoricoSolicitud")));
					}else {
						idSolicitud = null;
					}
				}
			}else {
				System.out.println("No tiene Histórico");
			}
			
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaMapHistoricaSolicitud;
	}
	
	@Override
	public List<Map<String, Object>> listarMapSolicitudXFechas(Date fechaInicio, Date fechaFin) {
		List<Map<String, Object>> listaMapSolicitud = null;
		try {
			listaMapSolicitud = mSolicitud.listarMapSolicitudXFechas(fechaInicio,fechaFin);
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaMapSolicitud;
	}
	
	@Override
	public List<Map<String, Object>> listarMapSolicitudReporteQc(){
		List<Map<String, Object>> listaMapSolicitud = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listaMapSolicitudReporteQC = new ArrayList<Map<String, Object>>();
		Map<String, Object> solicitud = null;
		Integer idSolicitud;
		try {
			listaMapSolicitud = mSolicitud.listarMapSolicitudReporteQC();
			for (Map<String, Object> map : listaMapSolicitud) {
				idSolicitud = Integer.parseInt(String.valueOf(map.get("idHistorico")));
				while (idSolicitud!=null) {
					solicitud = mSolicitud.MapSolicitudxIdHistorico(idSolicitud);
					if(Integer.parseInt(String.valueOf(solicitud.get("idEstadoSolicitud")))==1) {
						idSolicitud = null;
					}else {
						idSolicitud = Integer.parseInt(String.valueOf(solicitud.get("idHistoricoSolicitud")));
					}
				}
				String fechaRegistrada = (String.valueOf(solicitud.get("fechaSolicitud"))).split(" ")[0];
				String fechaSolicitudFinalizada = (String.valueOf(map.get("fechaSolicitudFinalizada"))).split(" ")[0];
				map.put("fechaSolicitudRegistrada", fechaRegistrada);
				map.put("fechaSolicitudFinalizada", fechaSolicitudFinalizada);
				if(map.get("snDetalleSolicitud")!=null){
					map.put("ssDetalleSolicitud", "-");
					map.put("incDetalleSolicitud", "-");
				} else if(map.get("ssDetalleSolicitud")!=null) {
					map.put("snDetalleSolicitud", "-");
					map.put("stDetalleSolicitud", "-");
					map.put("incDetalleSolicitud", "-");
				} else if(map.get("incDetalleSolicitud")!=null) {
					map.put("snDetalleSolicitud", "-");
					map.put("stDetalleSolicitud", "-");
					map.put("ssDetalleSolicitud", "-");
				}
				listaMapSolicitudReporteQC.add(map);
			}
		} catch (PersistenciaExcepcion e) {
			throw new NegocioExcepcion(Constantes.ERROR_NEGOCIO_CONSULTA_REGISTRO, e);
		} catch (Exception e) {
			throw new NegocioExcepcion(
					Constantes.ERROR_GENERAL_LOGICA_NEGOCIO, e);
		}
		return listaMapSolicitudReporteQC;
	}
	
}
