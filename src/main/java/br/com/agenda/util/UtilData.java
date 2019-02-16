package br.com.agenda.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class UtilData {
    // representa Domingo
    static final int DOMINGO = Calendar.SUNDAY;

    // Segunda-Feira
    static final int SEGUNDA = Calendar.MONDAY;

    // Terça-Feira
    static final int TERÇA = Calendar.TUESDAY;

    // Quarta-Feira
    static final int QUARTA = Calendar.WEDNESDAY;

    // Quinta-Feira
    static final int QUINTA = Calendar.THURSDAY;

    // Sexta-Feira
    static final int SEXTA = Calendar.FRIDAY;

    // Sábado
    static final int SABADO = Calendar.SATURDAY;

    // Constrói uma data representando agora
    public static LocalDate dataAtual() {
        return LocalDate.now();
    }

    public static LocalDateTime data(int dia, int mes, int ano, int hora, int min, int seg) {

        return LocalDateTime.of(dia, mes, ano, hora, min, seg);
    }

    public static LocalDate data(int dia, int mes, int ano) {

        return LocalDate.of(ano, mes, dia);
    }

    public static LocalDate data(java.sql.Date date) {
        return date.toLocalDate();
    }

    // Retorna uma data com dia, mes e ano passado como String e formato como argumento
    public static LocalDate data(String data) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //convert String to LocalDate
        try {
            return LocalDate.parse(data, formatter);
        } catch (Exception e) {
            return LocalDate.parse(data);
        }
    }

    // Formata uma data no formato dd/mm/aaaa
    public static String DDMMAAAA(LocalDate data) {

        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    // Formata uma data no formato dd/mm/aaaa hh:mm
    public static String DDMMAAAAHHMM(LocalDate data) {

        return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
    }

    // método estático que retorna o valor da data formatado como String
    public static String formataData(LocalDate data) {

        return new java.text.SimpleDateFormat("dd/MM/yyyy  HH:mm").format(data);
    }

}
