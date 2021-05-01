package br.com.reqres.automation.utils;

import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {

    private static final Logger aLogger = LogUtils.getLogger();
    private static final SimpleDateFormat aFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private static void mensagem(String pMensagemFinal) {
        aLogger.info(pMensagemFinal);
    }

    public static void info(String pMensagem) {
        try {
            mensagem(getCabecalho("INFO") + pMensagem);
        } catch (Exception e) {
        }
    }

    private static String getCabecalho(String pTipo) {
        return String.format("[%s] [%s] [%s] ", pTipo, aFormat.format(Calendar.getInstance().getTime()));
    }
}
