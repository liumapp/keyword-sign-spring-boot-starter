package com.liumapp.keywordsign.core.keyword.impl;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.IPdfTextLocation;
import com.itextpdf.kernel.pdf.canvas.parser.listener.RegexBasedLocationExtractionStrategy;
import com.liumapp.keywordsign.core.exceptions.KeyStoreException;
import com.liumapp.keywordsign.core.keyword.Keyword;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.sun.tools.javac.util.BaseFileManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * file KeywordCore.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/9/4
 */
public class KeywordCore implements Keyword {

    protected KeywordCore () {

    }

    @Override
    public List<HashMap<String, Float>> getKeywordPosition(String pdfBase64, String keyword) {
        try {
            PdfReader reader = new PdfReader(Base64FileTool.decodeBase64ToInputStream(pdfBase64));
            PdfDocument pdfDocument = new PdfDocument(reader);
            List<HashMap<String, Float>> resultMaps = new ArrayList<>();

            for (int i = 1; i <= pdfDocument.getNumberOfPages(); i++) {
                PdfPage page = pdfDocument.getPage(i);
                
            }
            List<OverAreaDTO> overAreaDTOS = new ArrayList<OverAreaDTO>();

//            for (String key : keyMap.keySet()) {

                PdfPage page = pdfDocument.getPage(i);

                RegexBasedLocationExtractionStrategy strategy = new RegexBasedLocationExtractionStrategy(keyMap.get(key));
                PdfCanvasProcessor canvasProcessor = new PdfCanvasProcessor(strategy);
                canvasProcessor.processPageContent(page);
                Collection<IPdfTextLocation> resultantLocations = strategy.getResultantLocations();
                PdfCanvas pdfCanvas = new PdfCanvas(page);
                pdfCanvas.setLineWidth(0.5f);
        } catch(Exception e){
            throw new KeyStoreException("获取关键词位置信息出现异常", e.getCause());
        }

            return null;
        }

}
