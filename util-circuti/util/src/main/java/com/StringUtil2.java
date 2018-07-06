package com;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringUtil2 implements Serializable {

    private static final long serialVersionUID = -3337306448722842363L;

    public String formataContato(String contato) {
        contato = contato.replace(" ", "");
        contato = contato.replace("(", "");
        contato = contato.replace(")", "");
        contato = contato.replace("-", "");

        if (contato.startsWith("0")) {
            contato = contato.substring(1, contato.length());
        }

        return contato;
    }

    public boolean existePeloMenosUmNumeroNaString(String str) {
        Pattern pat = Pattern.compile("\\d");
        Matcher matcher = pat.matcher(str);
        return matcher.find();
    }

    public void capitalizarAtributosString(Object obj, String... excessoes) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        List<String> excessoesList = Arrays.asList(excessoes);
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.getType().equals(String.class) && !excessoesList.contains(field.getName())) {
                try {
                    String campoString = (String) field.get(obj);
                    if (campoString != null) {
                        field.set(obj, campoString.toUpperCase());

                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {

                }
            }
        }
    }

    public static String adicionarAspasNaString(String texto) {
        if (StringUtils.isNotBlank(texto)) {
            return "\"" + texto + "\"";
        } else {
            return texto;
        }
    }

    public static String removerAcentuacao(String input) {
        if (StringUtils.isBlank(input)) {
            return "";
        }
        String output = Normalizer.normalize(input, Normalizer.Form.NFD);
        output = output.replaceAll("[^\\p{ASCII}]", "");
        return output;
    }

    public static String removeEspaçoExtremidades(String texto) {
        texto = StringUtils.stripStart(texto, " \t");
        texto = StringUtils.stripEnd(texto, " \t");

        return texto;
    }

    public static String removeEspaçosEntreString(String texto) {
        texto = texto.replaceAll("\\s+", " ");
        return texto;
    }

    /**
     * Troca os caracteres especiais da string por ""
     *
     */
    public static String removeCaracteresEspeciais(String texto) {
        String[] caracteresEspeciais = {"\\.", ",", "-", ":", ";", "\\(", "\\)", "ª", "\\|", "\\\\", "°", "'", "@", "!", "`"};
        for (int i = 0; i < caracteresEspeciais.length; i++) {
            texto = texto.replaceAll(caracteresEspeciais[i], "");
        }
        return texto;
    }

    /**
     * Metodo criado para remover acentuação e retirar espaços, pois o Esus
     * exige nomes nessa regra
     *
     * @param nome
     * @return
     */
    public static String retornaNomeTratadoParaExportEsus(String nome) {
        String nomeTratado = removeEspaçoExtremidades(nome);
        nomeTratado = removerAcentuacao(nomeTratado);
        nomeTratado = removeEspaçosEntreString(nomeTratado);
        nomeTratado = removeCaracteresEspeciais(nomeTratado);

        nomeTratado = nomeTratado.replace(" D ", " DE ");

        if (nomeTratado.length() <= 3 || nomeTratado.contains("IGNORADO") || nomeTratado.contains("DESCONHECIDO")) {
            return "";
        }

        return nomeTratado;
    }

    /**
     * Método para formatar número de telefone, considerando casos como:
     * "3631.1107", "19-3633.5152", "3631.1512- 3622.3483" etc.
     *
     * @param string
     * @return string
     */
    public static String contatoTokenizer(String string) {
        String contato = "";
        String caracteres = "()-. ";
        String[] tokens = string.split("[" + Pattern.quote(caracteres) + "]");
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i].length()) {
                case 2:
                    tokens[i] = "(" + tokens[i] + ") ";
                    break;
                case 3:
                    tokens[i] = "(" + tokens[i].replace("0", "") + ") ";
                    break;
                case 4:
                    if (tokens[i - 1].contains("(") || tokens[i - 1].contains(")")) {
                        tokens[i] = tokens[i] + "-";
                    } else {
                        tokens[i] = tokens[i] + " ";
                    }
                    break;
                case 5:
                    if (tokens[i - 1].contains("(") || tokens[i - 1].contains(")")) {
                        tokens[i] = tokens[i] + "-";
                    } else {
                        tokens[i] = tokens[i] + " ";
                    }
                    break;
                case 8:
                    tokens[i] = tokens[i].substring(0, 4) + "-" + tokens[i].substring(4) + " ";
                    break;
                case 9:
                    tokens[i] = tokens[i].substring(0, 5) + "-" + tokens[i].substring(5) + " ";
                    break;
                default:
                    break;
            }
            contato += tokens[i];
        }
        return StringUtils.removeEnd(contato, " ");
    }

    /**
     * Método que trunca a String de acordo com o comprimento (length) que o
     * campo deve ter.
     *
     * @param string
     * @param length
     * @return String
     * @since 1.5.80.00 do salute
     */
    public static String truncarString(String string, int length) {
        if (string == null || string.length() < length) {
            return string;
        } else {
            return string.substring(0, length);
        }
    }
}
