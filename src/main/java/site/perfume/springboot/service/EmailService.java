package site.perfume.springboot.service;


import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender mailSender;



    public void enviarEmailBoasVindas(String para, String nome) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom("projetogrupo3@escolatecnicaadelia.com.br");
            helper.setTo(para);
            helper.setSubject("Bem-Vindo à nossa loja!");

            String htmlContent = String.format("""
                <html>
                    <body>
                        <h2>Olá %s,</h2>
                        <p>Seja Bem-Vindo à nossa loja!</p>
                        <p>Seu cadastro foi realizado com sucesso.</p>
                        <br>
                        <p>Atenciosamente,<br>
                        Equipe Linsley</p>
                    </body>
                </html>
                """, nome);

            helper.setText(htmlContent, true);

            System.out.println("Tentando enviar email para: " + para);
            mailSender.send(mimeMessage);
            System.out.println("Email enviado com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro detalhado ao enviar email:");
            e.printStackTrace(); // Isso vai mostrar a stack trace completa
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage());
        }
    }

    public void enviarEmailCompra(String para, String nome) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setFrom("projetogrupo3@escolatecnicaadelia.com.br");
            helper.setTo(para);
            helper.setSubject("Bem-Vindo à nossa loja!");

            String htmlContent = String.format("""
                <html>
                    <body>
                        <h2>Olá %s,</h2>
                        <p>Seja Bem-Vindo à nossa loja!</p>
                        <p>Seu pedido foi efeteuado com sucesso.</p>
                        <br>
                        <p>Atenciosamente,<br>
                        Equipe Linsley</p>
                    </body>
                </html>
                """, nome);

            helper.setText(htmlContent, true);

            System.out.println("Tentando enviar email para: " + para);
            mailSender.send(mimeMessage);
            System.out.println("Email enviado com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro detalhado ao enviar email:");
            e.printStackTrace(); // Isso vai mostrar a stack trace completa
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage());
        }
    }


}
