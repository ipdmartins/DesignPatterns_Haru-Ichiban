/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import abstractFactory.StringComum;
import java.util.ArrayList;
import java.util.List;
import visitor.Visitor;

/**
 *
 * @author ipdmartins
 */
public abstract class Player implements StringComum{
    
    private int status;
    private int pontos;
    private boolean pegouFlor;
    private boolean mostrouFlor;
    private boolean definiuSatus;
    private boolean posicionou;
    private boolean ventou;
    private boolean setoudark;
    private List<String> list;

    public Player() {
        this.list = new ArrayList<>();
        this.pontos = 0;
        this.status = -1;
        this.pegouFlor = false;
        this.mostrouFlor = false;
        this.definiuSatus = false;
        this.posicionou = false;
        this.ventou = false;
        this.setoudark = false;
    }
    
    public void add(String s){
        list.add(s);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos += pontos;
    }

    public boolean isPegouFlor() {
        return pegouFlor;
    }

    public void setPegouFlor(boolean pegouFlor) {
        this.pegouFlor = pegouFlor;
    }

    public boolean isPosicionou() {
        return posicionou;
    }

    public void setPosicionou(boolean posicionou) {
        this.posicionou = posicionou;
    }
    
    public boolean isMostrouFlor() {
        return mostrouFlor;
    }

    public void setMostrouFlor(boolean mostrouFlor) {
        this.mostrouFlor = mostrouFlor;
    }

    public boolean isDefiniuSatus() {
        return definiuSatus;
    }

    public void setDefiniuSatus(boolean definiuSatus) {
        this.definiuSatus = definiuSatus;
    }

    public boolean isVentou() {
        return ventou;
    }

    public void setVentou(boolean ventou) {
        this.ventou = ventou;
    }

    public boolean isSetoudark() {
        return setoudark;
    }

    public void setSetoudark(boolean setoudark) {
        this.setoudark = setoudark;
    }
    
    
    
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
    @Override
    public String receberString(int num) {
        return list.get(num);
    }
    
    public abstract void accept(Visitor visitor);
    
}
