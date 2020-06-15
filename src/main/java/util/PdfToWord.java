package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfToWord {
    public static void main(String[] args) {
        /*try {
            String pdfFile = "C:\\Users\\admin\\Desktop\\aaa.pdf";
            PDDocument doc = PDDocument.load(new File(pdfFile));
            int pagenumber = doc.getNumberOfPages();
            pdfFile = pdfFile.substring(0, pdfFile.lastIndexOf("."));
            String fileName = pdfFile + ".doc";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.writeText(doc, writer);
            writer.close();
            doc.close();
            System.out.println("pdf转换word成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        pdftoword();
    }



    public static void  pdftoword(){

        try {
            //pdf文件路径
            String filePath = "C:\\Users\\admin\\Desktop\\aaa.pdf";
            File fdf = new File(filePath);
            //生成的word的文件路径
            String wordPath = "C:\\Users\\admin\\Desktop\\aaa.docx";
            //通过文件名加载文档
            PDDocument doc = PDDocument.load(fdf);
            //获取文档的页数
            int pageNumber = doc.getNumberOfPages();
            //剥离器（读取pdf文件）
            PDFTextStripper stripper = new PDFTextStripper();
            //排序
            stripper.setSortByPosition(true);
            //设置要读取的起始页码
            stripper.setStartPage(1);
            //设置要读取的结束页码
            stripper.setEndPage(pageNumber);
            File word = new File(wordPath);
            if(!word.exists()){
                word.createNewFile();
            }
            //文件输出流
            FileOutputStream fos = new FileOutputStream(word);
            //
            Writer  writer = new OutputStreamWriter(fos, "utf-8");
            stripper.writeText(doc, writer);
            writer.close();
            fos.close();
            System.out.println("转码完成");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
