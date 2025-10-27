package com.vivo.vivoare.controler;

import com.vivo.vivoare.dto.arequipaBene;
import com.vivo.vivoare.dto.arequipaVivo;
import com.vivo.vivoare.dto.provinciaBene;
import com.vivo.vivoare.dto.provinciaVivo;
import com.vivo.vivoare.service.capturaPBeneService;
import com.vivo.vivoare.service.capturaPVivoService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
@RequestMapping("/reporte")
public class reporteController {

    private final capturaPBeneService service;
    private final capturaPVivoService serviceVivo;

    public reporteController(capturaPBeneService service, capturaPVivoService serviceVivo) {
        this.service = service;
        this.serviceVivo = serviceVivo;
    }

    // Exportar Arequipa a Excel
    @GetMapping("/beneficiado/arequipa/excel")
    public ResponseEntity<byte[]> exportarArequipaExcel() throws Exception {
        List<arequipaBene> lista = service.getListArequipaBene();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Arequipa Beneficiados");

            // Encabezados
            Row header = sheet.createRow(0);
            String[] columnas = {"Año", "Mes", "Provincia", "Zona", "Compra GRS", "tipo de Cliente",
                    "Nombres", "GRS", "RP", "RENZO", "AVELINO", "PELADORES", "AVICRUZ", "RAFAEL",
                    "MATILDE", "AVIROX", "JULIA", "SIMON", "YESICA", "GABRIEL", "ARTURO", "NICOLAS",
                    "LUIS FLORES", "MIRELLA", "OTROS", "Potencial Mínimo", "Potencial Máximo", "Condiciones para Potencial Maximo"};
            for (int i = 0; i < columnas.length; i++) {
                header.createCell(i).setCellValue(columnas[i]);
            }

            // Datos
            int rowNum = 1;
            for (arequipaBene bene : lista) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(bene.getAno());
                row.createCell(1).setCellValue(bene.getMes());
                row.createCell(2).setCellValue(bene.getProvincia());
                row.createCell(3).setCellValue(bene.getZona());
                row.createCell(4).setCellValue(bene.getCompraGrs());
                row.createCell(5).setCellValue(bene.getTipoCliente());
                row.createCell(6).setCellValue(bene.getNombre());
                row.createCell(7).setCellValue(bene.getGrs());
                row.createCell(8).setCellValue(bene.getRp());
                row.createCell(9).setCellValue(bene.getAvicola_renzo());
                row.createCell(10).setCellValue(bene.getAvelino());
                row.createCell(11).setCellValue(bene.getPeladores());
                row.createCell(12).setCellValue(bene.getAvicruz());
                row.createCell(13).setCellValue(bene.getRafael());
                row.createCell(14).setCellValue(bene.getMatilde());
                row.createCell(15).setCellValue(bene.getAvirox());
                row.createCell(16).setCellValue(bene.getJulia());
                row.createCell(17).setCellValue(bene.getSimon());
                row.createCell(18).setCellValue(bene.getYesica());
                row.createCell(19).setCellValue(bene.getGabriel());
                row.createCell(20).setCellValue(bene.getArturo());
                row.createCell(21).setCellValue(bene.getNicolas());
                row.createCell(22).setCellValue(bene.getLuis_f());
                row.createCell(23).setCellValue(bene.getMirella());
                row.createCell(24).setCellValue(bene.getOtros());
                row.createCell(25).setCellValue(bene.getPotencialMinimo());
                row.createCell(26).setCellValue(bene.getPotencialMaximo());
                row.createCell(27).setCellValue(bene.getCondicionPtmax());
            }

            // Autoajustar columnas
            for (int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Convertir a bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            // Preparar respuesta
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ArequipaBeneficiados.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(outputStream.toByteArray());
        }
    }

    @GetMapping("/beneficiado/provincia/excel")
    public ResponseEntity<byte[]> exportarProvinciaExcel() throws Exception {
        List<provinciaBene> lista = service.getListProvinciaBene();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Provincia Beneficiados");

            Row header = sheet.createRow(0);
            String[] columnas = {"Año", "Mes", "Provincia", "Zona", "Compra GRS", "Tipo de Cliente", "Nombres",
                    "GRS", "RP", "GRS Vivo", "Santa Elena", "Granjas Chicas", "Rosario",
                    "San Fernando Lima", "Avícola Renzo", "OTROS",
                    "Potencial Mínimo", "Potencial Máximo",
                    "Condición Potencial Mínimo", "Condición Potencial Máximo", "Observaciones"};

            for (int i = 0; i < columnas.length; i++) {
                header.createCell(i).setCellValue(columnas[i]);
            }

            int rowNum = 1;
            for (provinciaBene bene : lista) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(bene.getAno());
                row.createCell(1).setCellValue(bene.getMes());
                row.createCell(2).setCellValue(bene.getProvincia());
                row.createCell(3).setCellValue(bene.getZona());
                row.createCell(4).setCellValue(bene.getCompraGrs());
                row.createCell(5).setCellValue(bene.getTipoCliente());
                row.createCell(6).setCellValue(bene.getNombre());
                row.createCell(7).setCellValue(bene.getGrs());
                row.createCell(8).setCellValue(bene.getRp());
                row.createCell(9).setCellValue(bene.getGrs_vivo());
                row.createCell(10).setCellValue(bene.getSanta_elena());
                row.createCell(11).setCellValue(bene.getGranjas_chicas());
                row.createCell(12).setCellValue(bene.getRosario());
                row.createCell(13).setCellValue(bene.getSanfern_lima());
                row.createCell(14).setCellValue(bene.getAvicola_renzo());
                row.createCell(15).setCellValue(bene.getOtros());
                row.createCell(16).setCellValue(bene.getPotencialMinimo());
                row.createCell(17).setCellValue(bene.getPotencialMaximo());
                row.createCell(18).setCellValue(bene.getCondicionPtmin());
                row.createCell(19).setCellValue(bene.getCondicionPtmax());
                row.createCell(20).setCellValue(bene.getObservaciones());
            }

            for (int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProvinciaBeneficiados.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(outputStream.toByteArray());
        }
    }

    @GetMapping("/vivo/arequipa/excel")
    public ResponseEntity<byte[]> exportarArequipaVivoExcel() throws Exception {
        List<arequipaVivo> lista = serviceVivo.getListArequipaVivo();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Arequipa Vivo");

            Row header = sheet.createRow(0);
            String[] columnas = {"Año", "Mes", "Provincia", "Zona", "Compra", "Tipo de Cliente", "Nombre",
                    "GRS", "RP", "Renzo", "Fafo", "Santa Angela", "Rosario",
                    "Pollo Lima", "Otras Granjas Chicas",
                    "Potencial Mínimo", "Potencial Máximo",
                    "Condición Potencial Mínimo", "Condición Potencial Máximo", "Observaciones"};

            for (int i = 0; i < columnas.length; i++) {
                header.createCell(i).setCellValue(columnas[i]);
            }

            int rowNum = 1;
            for (arequipaVivo vivo : lista) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(vivo.getAno());
                row.createCell(1).setCellValue(vivo.getMes());
                row.createCell(2).setCellValue(vivo.getProvincia());
                row.createCell(3).setCellValue(vivo.getZona());
                row.createCell(4).setCellValue(vivo.getCompra());
                row.createCell(5).setCellValue(vivo.getTipo_cliente());
                row.createCell(6).setCellValue(vivo.getNombre());
                row.createCell(7).setCellValue(vivo.getGrs());
                row.createCell(8).setCellValue(vivo.getRp());
                row.createCell(9).setCellValue(vivo.getRenzo());
                row.createCell(10).setCellValue(vivo.getFafo());
                row.createCell(11).setCellValue(vivo.getSanta_angela());
                row.createCell(12).setCellValue(vivo.getRosario());
                row.createCell(13).setCellValue(vivo.getPollo_lima());
                row.createCell(14).setCellValue(vivo.getOtras_granjas_chicas());
                row.createCell(15).setCellValue(vivo.getPotencial_minimo());
                row.createCell(16).setCellValue(vivo.getPotencial_maximo());
                row.createCell(17).setCellValue(vivo.getCondicion_ptmin());
                row.createCell(18).setCellValue(vivo.getCondicion_ptmax());
                row.createCell(19).setCellValue(vivo.getObservaciones());
            }

            for (int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ArequipaVivo.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(outputStream.toByteArray());
        }
    }

    @GetMapping("/vivo/provincia/excel")
    public ResponseEntity<byte[]> exportarProvinciaVivoExcel() throws Exception {
        List<provinciaVivo> lista = serviceVivo.getListProvinciaVivo();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Provincia Vivo");

            Row header = sheet.createRow(0);
            String[] columnas = {"Año", "Mes", "Provincia", "Zona", "Compra", "Tipo de Cliente", "Nombre",
                    "GRS", "RP", "Renzo", "Fafo", "Santa Angela", "Jorge Pan",
                    "Mirian G", "Vasquez", "San Joaquin", "Fortunato", "Rosario",
                    "Perca", "Gamboa", "Asoc Sondor", "Otras Granjas Chicas",
                    "Potencial Mínimo", "Potencial Máximo", "Condición Potencial Máximo", "Observaciones"};

            for (int i = 0; i < columnas.length; i++) {
                header.createCell(i).setCellValue(columnas[i]);
            }

            int rowNum = 1;
            for (provinciaVivo vivo : lista) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(vivo.getAno());
                row.createCell(1).setCellValue(vivo.getMes());
                row.createCell(2).setCellValue(vivo.getProvincia());
                row.createCell(3).setCellValue(vivo.getZona());
                row.createCell(4).setCellValue(vivo.getCompra());
                row.createCell(5).setCellValue(vivo.getTipo_cliente());
                row.createCell(6).setCellValue(vivo.getNombre());
                row.createCell(7).setCellValue(vivo.getGrs());
                row.createCell(8).setCellValue(vivo.getRp());
                row.createCell(9).setCellValue(vivo.getRenzo());
                row.createCell(10).setCellValue(vivo.getFafo());
                row.createCell(11).setCellValue(vivo.getSanta_angela());
                row.createCell(12).setCellValue(vivo.getJorge_pan());
                row.createCell(13).setCellValue(vivo.getMirian_g());
                row.createCell(14).setCellValue(vivo.getVasquez());
                row.createCell(15).setCellValue(vivo.getSan_joaquin());
                row.createCell(16).setCellValue(vivo.getFortunato());
                row.createCell(17).setCellValue(vivo.getRosario());
                row.createCell(18).setCellValue(vivo.getPerca());
                row.createCell(19).setCellValue(vivo.getGamboa());
                row.createCell(20).setCellValue(vivo.getAsoc_sondor());
                row.createCell(21).setCellValue(vivo.getOtras_granjas_chicas());
                row.createCell(22).setCellValue(vivo.getPotencial_minimo());
                row.createCell(23).setCellValue(vivo.getPotencial_maximo());
                row.createCell(24).setCellValue(vivo.getCondicion_ptmax());
                row.createCell(25).setCellValue(vivo.getObservaciones());
            }

            for (int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProvinciaVivo.xlsx")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(outputStream.toByteArray());
        }
    }


}
