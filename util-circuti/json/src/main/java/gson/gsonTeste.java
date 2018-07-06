package gson;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

public class gsonTeste {

    public static void main(String[] args) {
        MyBean bean = new MyBean();
        bean.data = "some data";
        bean.problem = new RuntimeException("Ack!");
        
        String toJson = new Gson().toJson(bean);
        System.out.println(toJson);
        
        MyBean fromJson = new Gson().fromJson(toJson, MyBean.class);
        System.out.println(fromJson);
        
    }
}

class MyBean implements Serializable{

    private static final long serialVersionUID = -6772417175279039904L;
    
    @Expose()
    public String data;
    
    public Exception problem;
}

//public class gsonTeste {
//    public static void main(String[] args) {
//        String stringJson = "{'concurso': { 'numero':1499, 'dataSorteio':'01/06/2013', 'dezenas':[8,22,26,33,37,54] } }";
//
//        Gson gson = new Gson();
//
//        Resposta res = gson.fromJson(stringJson, Resposta.class);
//
//        Concurso concurso = res.concurso;
//        
//        System.err.println(concurso);
//
//    }
//}
//
//class Resposta{
//
//    Concurso concurso;
//}
//
//class Concurso{
//
//
//    private int numero;
//    private String dataSorteio;
//    private int[] dezenas;
//
//    public Concurso() {
//    }
//
//    @Override
//    public String toString() {
//
//        return numero + " - " + dataSorteio;
//    }
//
//}
