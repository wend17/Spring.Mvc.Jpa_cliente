package com.datajpa.app.Page;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender <T>{

    private String url;
    private Page <T> page;
     private int totaldePaginas;
     private int numElementosPorPagina;
     private int paginaActual;

     private List<PageItem> paginas; // luego de crear PageItem

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas=new ArrayList<PageItem>(); // luego de crear PageItem

        numElementosPorPagina=page.getSize();
        totaldePaginas=page.getTotalPages();
        paginaActual=page.getNumber()+1;

        int desde,hasta;
    if(totaldePaginas<=numElementosPorPagina){
            desde=1;
            hasta = totaldePaginas;
        }
            else{
                if(paginaActual<= numElementosPorPagina/2){
                    desde=1;
                    hasta=numElementosPorPagina;
                }
                else if(paginaActual>=totaldePaginas-numElementosPorPagina/2){
                 desde = totaldePaginas - numElementosPorPagina + 1;
                 hasta = numElementosPorPagina;
            }else{
                    desde=paginaActual-numElementosPorPagina/2;
                    hasta=numElementosPorPagina;
                }
        }
            for (int i=0;i < hasta; i++) { // para cada pag y si es actual
               paginas.add(new PageItem(desde + i,paginaActual==desde+i));
            }
    }

    public String getUrl() {
        return url;
    }

    public Page<T> getPage() {
        return page;
    }

    public int getTotaldePaginas() {
        return totaldePaginas;
    }

    public int getNumElementosPorPagina() {
        return numElementosPorPagina;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public List<PageItem> getPaginas() {
        return paginas;

    }

    public boolean isFirst(){
        return  page.isFirst();
    }
    public boolean isLast(){
        return page.isLast();
    }
    public boolean isHasNext(){
        return page.hasNext();
    }

    public  boolean isHasPrevious(){
        return page.hasPrevious();
    }
}
