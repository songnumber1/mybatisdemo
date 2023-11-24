package com.example.mybatis.demo.webp;

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
import org.springframework.util.ResourceUtils;

import com.zakgof.webp4j.Webp4j;

@Service
public class WebpServiceImpl implements WebpService {

    @Override
    public String webpConvertBase64() {
        
        String filePath = "E:\\Git project\\Spring\\mybatisdemo\\src\\main\\resources\\image\\1.webp";
        
        byte[] byteFile = null;
        String base64Img = null;
        try {
            byteFile = Files.readAllBytes(new File(filePath).toPath());

            ByteArrayInputStream in = new ByteArrayInputStream(byteFile);

            BufferedImage a = ImageIO.read(in);

            BufferedImage restored = Webp4j.decode(byteFile);

            Graphics2D g = restored.createGraphics();

            g.drawRect(0, 0, 200, 200);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            ImageIO.write(restored, "jpeg", baos);

            byte[] buffer = baos.toByteArray();

            base64Img = new String(Base64.getEncoder().encodeToString(buffer));

            System.out.println(a);

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return "data:image/webp;base64,"+base64Img;
    }
}
