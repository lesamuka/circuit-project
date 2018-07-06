/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fk1.salute.service.dialect;

import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

/**
 * 
 * @author Leonardo Rocha
 * @since 31/08/2017
 * Anteriormente o salute utilizava a classe org.hibernate.dialect.MySQL5InnoDBDialect; como  hibernate.Dialect no persistence.xml
 * visto que precisavamos adicionar novas funções ao nosso JPA criamos um dialect customizado que extende a classe MySQL5InnoDBDialect anteriormente utilizada como dialect principal.
 * Assim todos os métodos são automaticamente implementados em nossa classe.
 * 
 * Isso aconteceu pq o JPQL não reconhecia o comando date_sub(data, interval valor tipodedata) visto que ele interpretava o interval e bugava. Porém como nativeSQL tudo dava certo.
 * Gerando uma nova função, nada disso ocorre.
 */
public class MyCustomDialect extends MySQL5InnoDBDialect{

   public MyCustomDialect() {
        //mysql date_add function support.
        registerFunction("fn_date_sub", new SQLFunctionTemplate(StandardBasicTypes.DATE, "date_sub(?1, INTERVAL ?2 ?3)"));
        registerFunction("fn_date_add", new SQLFunctionTemplate(StandardBasicTypes.DATE, "date_add(?1, INTERVAL ?2 ?3)"));
    }
}
