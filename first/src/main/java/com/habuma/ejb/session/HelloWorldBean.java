package com.habuma.ejb.session;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.rmi.RemoteException;

public class HelloWorldBean implements SessionBean{ // Зачем все эти методы
    public void setSessionContext(SessionContext sessionContext) throws EJBException, RemoteException {

    }

    public void ejbPassivate() throws EJBException, RemoteException {

    }

    public void ejbRemove() throws EJBException, RemoteException {

    }

    public void ejbActivate(){

    }

    public String sayHello(){
        return "Hello World";
    }

    public void ejbCreate(){

    }
}
