package com.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author lv
 */
@Controller
public class YanController {

    @RequestMapping("/yan")
    public void verificationCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 80, 20);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font(null, Font.ITALIC, 20));
        String yanCode = RandomNum();
        graphics.drawString(yanCode, 5, 18);

        req.getSession().setAttribute("yanCode", yanCode);

        resp.setContentType("image/jpeg");
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");
        ImageIO.write(image, "jpeg", resp.getOutputStream());
    }

    private String RandomNum() {
        Random random = new Random();
        String num = random.nextInt(99999) + "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 5 - num.length(); i++) {
            stringBuffer.append(0);
        }
        num = stringBuffer.toString() + num;
        return num;
    }
}
