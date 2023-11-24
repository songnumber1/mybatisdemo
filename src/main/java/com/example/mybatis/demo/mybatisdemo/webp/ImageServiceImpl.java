package com.example.mybatis.demo.mybatisdemo.webp;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.zakgof.webp4j.Webp4j;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public String webpDrawRectConvertBase64(ImageDrawVo vo) {
        String filePath = "E:\\Git project\\Spring\\mybatisdemo\\src\\main\\resources\\image\\1.webp";
        
        byte[] byteFile = null;

        String base64Img = null;

        try {
            byteFile = Files.readAllBytes(new File(filePath).toPath());

            BufferedImage bufferedImage = Webp4j.decode(byteFile);

            Graphics2D graphics2d = bufferedImage.createGraphics();

            graphics2d.drawRect(vo.getX(), vo.getY(), vo.getWidth(), vo.getHeigth());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            ImageIO.write(bufferedImage, "jpeg", baos);

            byte[] buffer = baos.toByteArray();

            base64Img = new String(Base64.getEncoder().encodeToString(buffer));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return "data:image/webp;base64,"+base64Img;
    }

    @Override
    public String jpgDrawRectConvertBase64(ImageDrawVo vo) {
        String filePath = "E:\\Git project\\Spring\\mybatisdemo\\src\\main\\resources\\image\\1.jpg";
        
        byte[] byteFile = null;

        String base64Img = null;
        
        try {
            byteFile = Files.readAllBytes(new File(filePath).toPath());

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteFile);

            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);

            Graphics2D graphics2d = bufferedImage.createGraphics();

            graphics2d.drawRect(vo.getX(), vo.getY(), vo.getWidth(), vo.getHeigth());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            ImageIO.write(bufferedImage, "jpeg", baos);

            byte[] buffer = baos.toByteArray();

            base64Img = new String(Base64.getEncoder().encodeToString(buffer));

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return "data:image/jpg;base64,"+base64Img;
    }
}
