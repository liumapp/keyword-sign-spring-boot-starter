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

import java.util.*;

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
        List<HashMap<String, Float>> resultMaps = null;
        try {
            PdfReader reader = new PdfReader(Base64FileTool.decodeBase64ToInputStream(pdfBase64));
            PdfDocument pdfDocument = new PdfDocument(reader);
            resultMaps = new ArrayList<>();

            for (int i = 1; i <= pdfDocument.getNumberOfPages(); i++) {
                PdfPage page = pdfDocument.getPage(i);
                RegexBasedLocationExtractionStrategy strategy = new RegexBasedLocationExtractionStrategy(keyword);
                PdfCanvasProcessor canvasProcessor = new PdfCanvasProcessor(strategy);
                canvasProcessor.processPageContent(page);
                Collection<IPdfTextLocation> resultantLocations = strategy.getResultantLocations();
                for (IPdfTextLocation location : resultantLocations) {
                    HashMap<String, Float> item = new HashMap<>();
                    item.put("page", (float) i);
                    item.put("x", location.getRectangle().getX());
                    item.put("y", location.getRectangle().getY());
                    resultMaps.add(item);
                }
            }
        } catch(Exception e){
            throw new KeyStoreException("获取关键词位置信息出现异常", e.getCause());
        }

        return resultMaps;
    }

}
