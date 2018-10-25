package pe.qc.com.validator.negocio.bo;

import java.util.ArrayList;
import java.util.List;

import pe.qc.com.validator.util.Constantes;

public class BOValidacionClearCase {

	private BOClearCase boClearCasex;
	private List<BOClearCase> listabClearCase;
	private List<String> listaEntregables;
	private List<BOEntregables> listaCasos;
	private List<BOEntregables> listaBOEntregables;

	public BOValidacionClearCase() {
		listaEntregables = new ArrayList<>();
		listaBOEntregables = new ArrayList<>();

		listaBOEntregables.add(new BOEntregables("02AYD", "REF"));
		listaBOEntregables.add(new BOEntregables("02AYD", "DAD"));
		listaBOEntregables.add(new BOEntregables("02AYD", "RAD"));
		listaBOEntregables.add(new BOEntregables("02AYD", "RAS"));
		listaBOEntregables.add(new BOEntregables("02AYD", "RAF"));
		listaBOEntregables.add(new BOEntregables("02AYD", "DTD"));
		listaBOEntregables.add(new BOEntregables("02AYD", "RDT"));
		listaBOEntregables.add(new BOEntregables("02AYD", "MAP"));
		listaBOEntregables.add(new BOEntregables("02AYD", "RET"));
		listaBOEntregables.add(new BOEntregables("02AYD", "PRA"));
		listaBOEntregables.add(new BOEntregables("02AYD", "AEA"));
		listaBOEntregables.add(new BOEntregables("02AYD", "COE"));
		listaBOEntregables.add(new BOEntregables("02AYD", "RDT"));

		listaBOEntregables.add(new BOEntregables("03CONS", "MIS"));
		listaBOEntregables.add(new BOEntregables("03CONS", "RCO"));
		listaBOEntregables.add(new BOEntregables("03CONS", "PPR"));

		listaBOEntregables.add(new BOEntregables("04CERT", "REC"));
		listaBOEntregables.add(new BOEntregables("04CERT", "PDP"));

		listaBOEntregables.add(new BOEntregables("05PRD", "MU"));
		listaBOEntregables.add(new BOEntregables("05PRD", "IDR"));

		listaBOEntregables.add(new BOEntregables("06ADMCONF", "PACA"));
		listaBOEntregables.add(new BOEntregables("06ADMCONF", "CIS"));

		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FCI"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FDA"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FDC"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FDI"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FMQ"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FPT"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FCD"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FPA"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FAE"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FAS"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FDS"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FFW"));
		listaBOEntregables.add(new BOEntregables("07FRMTSTD", "FPH"));
		// listaEntregables.add("MIC");

		// listaEntregables.add("BDO");
		// listaEntregables.add("GO");
	}

	public void validarClearCase(List<BOClearCase> listaClearCase, Integer tipoSolicitud,
			BODetalleSolicitud detalleSolicitud, BOAplicativo boAplicativo, String tk) {
		String codigoAplicativo = boAplicativo.getNombreAplicativo();
		String validacion = "";
		String nomenclaturaIndicada = "";
		String validacion2 = "";
		System.out.println("AAAA" + listaClearCase.toString());
		if (tipoSolicitud == Constantes.SOL_NEGOCIO) {
			listabClearCase = new ArrayList<>();
			completarSolNegocio(codigoAplicativo, detalleSolicitud, tk);
			for (BOClearCase boClearCase : listaClearCase) {
				if (boClearCase.getElemento().contains("BDO.xml")) {
					String nomenclaturaCorrecta = "-BDO.xml";
					String nommenclaturaIncorrecta1 = " -BDO.xml";
					String nommenclaturaIncorrecta2 = "- BDO.xml";
					String nommenclaturaIncorrecta3 = " - BDO.xml";
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta1)) {
						validacion = "error de espacio en blanco entre COD. APP. y el guión";
					}
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta2)) {
						validacion = "error de espacio en blanco entre guión y entregable";
					}
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta3)) {
						validacion = "error de espacio en blanco entre COD. APP., guión y entregable";
					} else {
						if (boClearCase.getElemento().contains(nomenclaturaCorrecta)) {
							validacion = "ok";
						} else {
							validacion = "error en la nomenclatura";
						}
					}
					nomenclaturaIndicada = codigoAplicativo + "-BDO";
					if (boClearCase.getCarpeta().equals("03CONS")) {
						validacion2 = "ok";
					} else {
						validacion2 = "elemento no corresponde a carpeta correcta";
					}
					boClearCasex = new BOClearCase();
					boClearCasex.setElemento(boClearCase.getElemento());
					boClearCasex.setCarpeta(boClearCase.getCarpeta());
					boClearCasex.setRuta(boClearCase.getRuta());
					boClearCasex.setAmbiente(boClearCase.getAmbiente());
					boClearCasex.setFecha(boClearCase.getFecha());
					boClearCasex.setValidacion(validacion);
					boClearCasex.setValidacion2(validacion2);
					boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
					listabClearCase.add(boClearCasex);
				} else {
					if (boClearCase.getElemento().contains("GO.xml")) {
						String nomenclaturaCorrecta = "-GO.xml";
						String nommenclaturaIncorrecta1 = " -GO.xml";
						String nommenclaturaIncorrecta2 = "- GO.xml";
						String nommenclaturaIncorrecta3 = " - GO.xml";
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta1)) {
							validacion = "error de espacio en blanco entre COD. APP. y el guión";
						}
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta2)) {
							validacion = "error de espacio en blanco entre guión y entregable";
						}
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta3)) {
							validacion = "error de espacio en blanco entre COD. APP., guión y entregable";
						} else {
							if (boClearCase.getElemento().contains(nomenclaturaCorrecta)) {
								validacion = "ok";
							} else {
								validacion = "error en la nomenclatura";
							}
						}
						nomenclaturaIndicada = codigoAplicativo + "-GO";
						if (boClearCase.getCarpeta().equals("03CONS")) {
							validacion2 = "ok";
						} else {
							validacion2 = "elemento no corresponde a carpeta correcta";
						}
						boClearCasex = new BOClearCase();
						boClearCasex.setElemento(boClearCase.getElemento());
						boClearCasex.setCarpeta(boClearCase.getCarpeta());
						boClearCasex.setRuta(boClearCase.getRuta());
						boClearCasex.setAmbiente(boClearCase.getAmbiente());
						boClearCasex.setFecha(boClearCase.getFecha());
						boClearCasex.setValidacion(validacion);
						boClearCasex.setValidacion2(validacion2);
						boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
						listabClearCase.add(boClearCasex);
					} else {
						for (BOEntregables boEntregable : listaBOEntregables) {
							if (boClearCase.getElemento().contains(boEntregable.getElemento())) {
								List<String> nomenclaturaCorrecta = new ArrayList<>();
								for (BOEntregables boEntregables1 : listaCasos) {
									if (boEntregables1.getElemento().contains(boEntregable.getElemento())) {
										nomenclaturaCorrecta.add(boEntregables1.getElemento());
									}
								}
								String nomenclaturaIncorrecta1 = " -";
								String nomenclaturaIncorrecta2 = "- ";
								String nomenclaturaIncorrecta3 = " .";
								String nomenclaturaIncorrecta4 = ". ";
								if (boClearCase.getElemento().contains(nomenclaturaIncorrecta1)) {
									validacion = "error de espacio en blanco antes del guión";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta2)) {
									validacion = "error de espacio en blanco despues del guión";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta3)) {
									validacion = "error de espacio en blanco antes del punto";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta4)) {
									validacion = "error de espacio en blanco despues del punto";
								} else {
									if (boClearCase.getElemento().contains("TK")) {
										if (boClearCase.getElemento().contains(tk)) {
											if (boClearCase.getElemento()
													.contains(detalleSolicitud.getSnDetalleSolicitud())) {
												if (boClearCase.getElemento()
														.contains(nomenclaturaCorrecta.get(1).trim())) {
													validacion = "ok";
												} else {
													validacion = "nomenclatura Incorreta";
												}
											} else {
												validacion = "error en el SN";
											}
										} else {
											validacion = "error en el TK";
										}
										nomenclaturaIndicada = nomenclaturaCorrecta.get(1).trim();
									} else {
										if (boClearCase.getElemento()
												.contains(detalleSolicitud.getSnDetalleSolicitud())) {
											if (boClearCase.getElemento()
													.contains(nomenclaturaCorrecta.get(0).trim())) {
												validacion = "ok";
											} else {
												validacion = "nomenclatura Incorreta";
											}
										} else {
											validacion = "error en el SN";
										}
										nomenclaturaIndicada = nomenclaturaCorrecta.get(0).trim();
									}
								}
								if (boClearCase.getCarpeta().equals(boEntregable.getCarpeta())) {
									validacion2 = "ok";
								} else {
									validacion2 = "elemento no corresponde a carpeta correcta";
								}
								if (boClearCase.getElemento().contains(".sql")) {

								} else {
									boClearCasex = new BOClearCase();
									boClearCasex.setElemento(boClearCase.getElemento());
									boClearCasex.setCarpeta(boClearCase.getCarpeta());
									boClearCasex.setRuta(boClearCase.getRuta());
									boClearCasex.setAmbiente(boClearCase.getAmbiente());
									boClearCasex.setFecha(boClearCase.getFecha());
									boClearCasex.setValidacion(validacion);
									boClearCasex.setValidacion2(validacion2);
									boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
									listabClearCase.add(boClearCasex);
								}
							}
						}
					}
				}
			}
		}
		if (tipoSolicitud == Constantes.SOL_SERVICIO) {
			completarSolServicio(codigoAplicativo, detalleSolicitud, tk);
			listabClearCase = new ArrayList<>();
			for (BOClearCase boClearCase : listaClearCase) {
				if (boClearCase.getElemento().contains("BDO")) {
					String nomenclaturaCorrecta = "-BDO.xml";
					String nommenclaturaIncorrecta1 = " -BDO.xml";
					String nommenclaturaIncorrecta2 = "- BDO.xml";
					String nommenclaturaIncorrecta3 = " - BDO.xml";
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta1)) {
						validacion = "error de espacio en blanco entre COD. APP. y el guión";
					}
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta2)) {
						validacion = "error de espacio en blanco entre guión y entregable";
					}
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta3)) {
						validacion = "error de espacio en blanco entre COD. APP., guión y entregable";
					} else {
						if (boClearCase.getElemento().contains(nomenclaturaCorrecta)) {
							validacion = "ok";
						} else {
							validacion = "error en la nomenclatura";
						}
					}
					nomenclaturaIndicada = codigoAplicativo + "-BDO";
					if (boClearCase.getCarpeta().equals("03CONS")) {
						validacion2 = "ok";
					} else {
						validacion2 = "elemento no corresponde a carpeta correcta";
					}
					boClearCasex = new BOClearCase();
					boClearCasex.setElemento(boClearCase.getElemento());
					boClearCasex.setCarpeta(boClearCase.getCarpeta());
					boClearCasex.setRuta(boClearCase.getRuta());
					boClearCasex.setAmbiente(boClearCase.getAmbiente());
					boClearCasex.setFecha(boClearCase.getFecha());
					boClearCasex.setValidacion(validacion);
					boClearCasex.setValidacion2(validacion2);
					boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
					listabClearCase.add(boClearCasex);
				} else {
					if (boClearCase.getElemento().contains("GO")) {
						String nomenclaturaCorrecta = "-GO.xml";
						String nommenclaturaIncorrecta1 = " -GO.xml";
						String nommenclaturaIncorrecta2 = "- GO.xml";
						String nommenclaturaIncorrecta3 = " - GO.xml";
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta1)) {
							validacion = "error de espacio en blanco entre COD. APP. y el guión";
						}
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta2)) {
							validacion = "error de espacio en blanco entre guión y entregable";
						}
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta3)) {
							validacion = "error de espacio en blanco entre COD. APP., guión y entregable";
						} else {
							if (boClearCase.getElemento().contains(nomenclaturaCorrecta)) {
								validacion = "ok";
							} else {
								validacion = "error en la nomenclatura";
							}
						}
						nomenclaturaIndicada = codigoAplicativo + "-GO";
						if (boClearCase.getCarpeta().equals("03CONS")) {
							validacion2 = "ok";
						} else {
							validacion2 = "elemento no corresponde a carpeta correcta";
						}
						boClearCasex = new BOClearCase();
						boClearCasex.setElemento(boClearCase.getElemento());
						boClearCasex.setCarpeta(boClearCase.getCarpeta());
						boClearCasex.setRuta(boClearCase.getRuta());
						boClearCasex.setAmbiente(boClearCase.getAmbiente());
						boClearCasex.setFecha(boClearCase.getFecha());
						boClearCasex.setValidacion(validacion);
						boClearCasex.setValidacion2(validacion2);
						boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
						listabClearCase.add(boClearCasex);
					} else {
						for (BOEntregables boEntregable : listaBOEntregables) {
							if (boClearCase.getElemento().contains(boEntregable.getElemento())) {
								List<String> nomenclaturaCorrecta = new ArrayList<>();
								for (BOEntregables boEntregables1 : listaCasos) {
									if (boEntregables1.getElemento().contains(boEntregable.getElemento())) {
										nomenclaturaCorrecta.add(boEntregables1.getElemento());
									}
								}
								String nomenclaturaIncorrecta1 = " -";
								String nomenclaturaIncorrecta2 = "- ";
								String nomenclaturaIncorrecta3 = " .";
								String nomenclaturaIncorrecta4 = ". ";
								if (boClearCase.getElemento().contains(nomenclaturaIncorrecta1)) {
									validacion = "error de espacio en blanco antes del guión";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta2)) {
									validacion = "error de espacio en blanco despues del guión";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta3)) {
									validacion = "error de espacio en blanco antes del punto";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta4)) {
									validacion = "error de espacio en blanco despues del punto";
								} else {
									if (boClearCase.getElemento().contains("TK")) {
										if (boClearCase.getElemento().contains(tk)) {
											if (boClearCase.getElemento()
													.contains(detalleSolicitud.getSsDetalleSolicitud())) {
												if (boClearCase.getElemento()
														.contains(nomenclaturaCorrecta.get(1).trim())) {
													validacion = "ok";
												} else {
													validacion = "nomenclatura Incorreta";
												}
											} else {
												validacion = "error en el SS";
											}
										} else {
											validacion = "error en el TK";
										}
										nomenclaturaIndicada = nomenclaturaCorrecta.get(1).trim();
									} else {
										if (boClearCase.getElemento()
												.contains(detalleSolicitud.getSsDetalleSolicitud())) {
											if (boClearCase.getElemento()
													.contains(nomenclaturaCorrecta.get(0).trim())) {
												validacion = "ok";
											} else {
												validacion = "nomenclatura Incorreta";
											}
										} else {
											validacion = "error en el SS";
										}
										nomenclaturaIndicada = nomenclaturaCorrecta.get(0).trim();
									}
								}
								if (boClearCase.getCarpeta().equals(boEntregable.getCarpeta())) {
									validacion2 = "ok";
								} else {
									validacion2 = "elemento no corresponde a carpeta correcta";
								}
								if (boClearCase.getElemento().contains(".sql")) {

								} else {
									boClearCasex = new BOClearCase();
									boClearCasex.setElemento(boClearCase.getElemento());
									boClearCasex.setCarpeta(boClearCase.getCarpeta());
									boClearCasex.setRuta(boClearCase.getRuta());
									boClearCasex.setAmbiente(boClearCase.getAmbiente());
									boClearCasex.setFecha(boClearCase.getFecha());
									boClearCasex.setValidacion(validacion);
									boClearCasex.setValidacion2(validacion2);
									boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
									listabClearCase.add(boClearCasex);
								}
							}
						}
					}
				}
			}
		}
		if (tipoSolicitud == Constantes.ERROR_EN_PRODUCCION) {
			completarSolServicio(codigoAplicativo, detalleSolicitud, tk);
			listabClearCase = new ArrayList<>();
			for (BOClearCase boClearCase : listaClearCase) {
				if (boClearCase.getElemento().contains("BDO")) {
					String nomenclaturaCorrecta = "-BDO.xml";
					String nommenclaturaIncorrecta1 = " -BDO.xml";
					String nommenclaturaIncorrecta2 = "- BDO.xml";
					String nommenclaturaIncorrecta3 = " - BDO.xml";
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta1)) {
						validacion = "error de espacio en blanco entre COD. APP. y el guión";
					}
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta2)) {
						validacion = "error de espacio en blanco entre guión y entregable";
					}
					if (boClearCase.getElemento().contains(nommenclaturaIncorrecta3)) {
						validacion = "error de espacio en blanco entre COD. APP., guión y entregable";
					} else {
						if (boClearCase.getElemento().contains(nomenclaturaCorrecta)) {
							validacion = "ok";
						} else {
							validacion = "error en la nomenclatura";
						}
					}
					nomenclaturaIndicada = codigoAplicativo + "-BDO";
					if (boClearCase.getCarpeta().equals("03CONS")) {
						validacion2 = "ok";
					} else {
						validacion2 = "elemento no corresponde a carpeta correcta";
					}
					boClearCasex = new BOClearCase();
					boClearCasex.setElemento(boClearCase.getElemento());
					boClearCasex.setCarpeta(boClearCase.getCarpeta());
					boClearCasex.setRuta(boClearCase.getRuta());
					boClearCasex.setAmbiente(boClearCase.getAmbiente());
					boClearCasex.setFecha(boClearCase.getFecha());
					boClearCasex.setValidacion(validacion);
					boClearCasex.setValidacion2(validacion2);
					boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
					listabClearCase.add(boClearCasex);
				} else {
					if (boClearCase.getElemento().contains("GO")) {
						String nomenclaturaCorrecta = "-GO.xml";
						String nommenclaturaIncorrecta1 = " -GO.xml";
						String nommenclaturaIncorrecta2 = "- GO.xml";
						String nommenclaturaIncorrecta3 = " - GO.xml";
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta1)) {
							validacion = "error de espacio en blanco entre COD. APP. y el guión";
						}
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta2)) {
							validacion = "error de espacio en blanco entre guión y entregable";
						}
						if (boClearCase.getElemento().contains(nommenclaturaIncorrecta3)) {
							validacion = "error de espacio en blanco entre COD. APP., guión y entregable";
						} else {
							if (boClearCase.getElemento().contains(nomenclaturaCorrecta)) {
								validacion = "ok";
							} else {
								validacion = "error en la nomenclatura";
							}
						}
						nomenclaturaIndicada = codigoAplicativo + "-GO";
						if (boClearCase.getCarpeta().equals("03CONS")) {
							validacion2 = "ok";
						} else {
							validacion2 = "elemento no corresponde a carpeta correcta";
						}
						boClearCasex = new BOClearCase();
						boClearCasex.setElemento(boClearCase.getElemento());
						boClearCasex.setCarpeta(boClearCase.getCarpeta());
						boClearCasex.setRuta(boClearCase.getRuta());
						boClearCasex.setAmbiente(boClearCase.getAmbiente());
						boClearCasex.setFecha(boClearCase.getFecha());
						boClearCasex.setValidacion(validacion);
						boClearCasex.setValidacion2(validacion2);
						boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
						listabClearCase.add(boClearCasex);
					} else {
						for (BOEntregables boEntregable : listaBOEntregables) {
							if (boClearCase.getElemento().contains(boEntregable.getElemento())) {
								String nomenclaturaCorrecta = "";
								for (BOEntregables boEntregables1 : listaCasos) {
									if (boEntregables1.getElemento().contains(boEntregable.getElemento())) {
										nomenclaturaCorrecta = boEntregables1.getElemento();
									}
								}
								String nomenclaturaIncorrecta1 = " -";
								String nomenclaturaIncorrecta2 = "- ";
								String nomenclaturaIncorrecta3 = " .";
								String nomenclaturaIncorrecta4 = ". ";
								if (boClearCase.getElemento().contains(nomenclaturaIncorrecta1)) {
									validacion = "error de espacio en blanco antes del guión";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta2)) {
									validacion = "error de espacio en blanco despues del guión";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta3)) {
									validacion = "error de espacio en blanco antes del punto";
								} else if (boClearCase.getElemento().contains(nomenclaturaIncorrecta4)) {
									validacion = "error de espacio en blanco despues del punto";
								} else {
									if (boClearCase.getElemento().contains("TK")) {
										if (boClearCase.getElemento().contains(tk)) {
											if (boClearCase.getElemento().contains(nomenclaturaCorrecta)) {
												validacion = "ok";
											} else {
												validacion = "nomenclatura Incorreta";
											}
										} else {
											validacion = "error en el TK";
										}
									} else {
										validacion = "error en no nombrar el TK";
									}
									nomenclaturaIndicada = codigoAplicativo + nomenclaturaCorrecta;
								}
								if (boClearCase.getCarpeta().equals(boEntregable.getCarpeta())) {
									validacion2 = "ok";
								} else {
									validacion2 = "elemento no corresponde a carpeta correcta";
								}
								boClearCasex = new BOClearCase();
								boClearCasex.setElemento(boClearCase.getElemento());
								boClearCasex.setCarpeta(boClearCase.getCarpeta());
								boClearCasex.setRuta(boClearCase.getRuta());
								boClearCasex.setAmbiente(boClearCase.getAmbiente());
								boClearCasex.setFecha(boClearCase.getFecha());
								boClearCasex.setValidacion(validacion);
								boClearCasex.setValidacion2(validacion2);
								boClearCasex.setNomenclaturaCorrecta(nomenclaturaIndicada);
								listabClearCase.add(boClearCasex);
							}
						}
					}
				}
			}
		}

	}

	public void completarSolNegocio(String codigo, BODetalleSolicitud detalleSolicitud, String tk) {
		listaCasos = new ArrayList<>();
		for (BOEntregables boEntregables : listaBOEntregables) {
			BOEntregables boEntregable2 = new BOEntregables();
			String estructura = codigo + "-" + boEntregables.getElemento() + "-"
					+ detalleSolicitud.getSnDetalleSolicitud();
			boEntregable2.setCarpeta(boEntregables.getCarpeta());
			boEntregable2.setElemento(estructura);
			listaCasos.add(boEntregable2);
		}

		for (BOEntregables boEntregables : listaBOEntregables) {
			BOEntregables boEntregable2 = new BOEntregables();
			String estructura = codigo + "-" + boEntregables.getElemento() + "-"
					+ detalleSolicitud.getSnDetalleSolicitud() + "-" + tk;
			boEntregable2.setCarpeta(boEntregables.getCarpeta());
			boEntregable2.setElemento(estructura);
			listaCasos.add(boEntregable2);
		}

	}

	public void completarSolServicio(String codigo, BODetalleSolicitud detalleSolicitud, String tk) {
		listaCasos = new ArrayList<>();
		for (BOEntregables boEntregables : listaBOEntregables) {
			BOEntregables boEntregable2 = new BOEntregables();
			String estructura = codigo + "-" + boEntregables.getElemento() + "-"
					+ detalleSolicitud.getSsDetalleSolicitud();
			boEntregable2.setCarpeta(boEntregables.getCarpeta());
			boEntregable2.setElemento(estructura);
			listaCasos.add(boEntregable2);
		}

		for (BOEntregables boEntregables : listaBOEntregables) {
			BOEntregables boEntregable2 = new BOEntregables();
			String estructura = codigo + "-" + boEntregables.getElemento() + "-"
					+ detalleSolicitud.getSsDetalleSolicitud() + "-" + tk;
			boEntregable2.setCarpeta(boEntregables.getCarpeta());
			boEntregable2.setElemento(estructura);
			listaCasos.add(boEntregable2);
		}

	}

	public void completarErrorProduccion(String codigo, BODetalleSolicitud detalleSolicitud, String tk) {
		listaCasos = new ArrayList<>();
		for (BOEntregables boEntregables : listaBOEntregables) {
			BOEntregables boEntregable2 = new BOEntregables();
			String estructura = codigo + "-" + boEntregables.getElemento() + "-" + tk;
			boEntregable2.setCarpeta(boEntregables.getCarpeta());
			boEntregable2.setElemento(estructura);
			listaCasos.add(boEntregable2);
		}

	}

	public BOClearCase getBoClearCasex() {
		return boClearCasex;
	}

	public void setBoClearCasex(BOClearCase boClearCasex) {
		this.boClearCasex = boClearCasex;
	}

	public List<BOClearCase> getListabClearCase() {
		return listabClearCase;
	}

	public void setListabClearCase(List<BOClearCase> listabClearCase) {
		this.listabClearCase = listabClearCase;
	}

	public List<String> getListaEntregables() {
		return listaEntregables;
	}

	public void setListaEntregables(List<String> listaEntregables) {
		this.listaEntregables = listaEntregables;
	}

	public List<BOEntregables> getListaCasos() {
		return listaCasos;
	}

	public void setListaCasos(List<BOEntregables> listaCasos) {
		this.listaCasos = listaCasos;
	}

	public List<BOEntregables> getListaBOEntregables() {
		return listaBOEntregables;
	}

	public void setListaBOEntregables(List<BOEntregables> listaBOEntregables) {
		this.listaBOEntregables = listaBOEntregables;
	}

}
