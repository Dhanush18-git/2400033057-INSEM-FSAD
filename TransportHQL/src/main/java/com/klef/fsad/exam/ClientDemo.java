package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDemo {

public static void main(String[] args)
{

Configuration cfg=new Configuration();
cfg.configure();

SessionFactory sf=cfg.buildSessionFactory();
Session session=sf.openSession();

session.beginTransaction();

Transport t1=new Transport(1,"Bus","2026-03-12","Active");
Transport t2=new Transport(2,"Train","2026-03-13","Inactive");

session.persist(t1);
session.persist(t2);

session.getTransaction().commit();

System.out.println("Records Inserted Successfully");

Query q=session.createQuery("from Transport");

List<Transport> list=q.list();

for(Transport t:list)
{
System.out.println(t.getId()+" "+t.getName()+" "+t.getDate()+" "+t.getStatus());
}

session.close();
sf.close();

}

}