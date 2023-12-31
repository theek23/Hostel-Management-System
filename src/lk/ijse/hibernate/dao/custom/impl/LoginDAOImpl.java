package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.LoginDAO;
import lk.ijse.hibernate.entity.Login;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public ArrayList<Login> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Login";
        Query query = session.createQuery(hql);
        List<Login> list = query.list();

        transaction.commit();
        session.close();
        Iterator<Login> itr = list.iterator();
        ArrayList<Login> allLogins = new ArrayList<>();
        while (itr.hasNext()){
            allLogins.add(itr.next());
        }
        return allLogins;
    }

    @Override
    public boolean save(Login entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Login entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Login search(String s) throws Exception {
        return null;
    }

    @Override
    public boolean isExists(String s) throws Exception {
        return false;
    }

    @Override
    public String generateNewId() throws Exception {
        return null;
    }

    @Override
    public Login getLogin(String userName, String password) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Login l WHERE l.userName=:u AND l.password=:p");
        query.setParameter("u", userName);
        query.setParameter("p", password);

        List<Login> list = query.list();

        transaction.commit();
        session.close();
        Iterator<Login> itr = list.iterator();
        if (itr.hasNext()){
            Login entity = itr.next();
            return entity;
        }
        return null;
    }

    @Override
    public boolean changeUsernameAndPasswordByCurrentUsername(String currentUserName, String newUserName, String newPassword) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("UPDATE Login l SET l.userName=:nu, l.password=:p WHERE l.userName=:cu");
        query.setParameter("nu", newUserName);
        query.setParameter("p", newPassword);
        query.setParameter("cu", currentUserName);

        int affectedRowCount = query.executeUpdate();

        transaction.commit();
        session.close();
        return affectedRowCount>0;
    }
}
