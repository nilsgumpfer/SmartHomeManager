package de.thm.smarthome.global.connection.database.user;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Persistence;

import de.thm.smarthome.global.connection.database.user.User;
import de.thm.smarthome.global.enumeration.ResponseCode;
//import com.mysql.jdbc.Extension;

       /**
 * Created by Nils on 04.02.2017.
 */
public class UserDAO {

    public EntityManagerFactory emf = null;
    public EntityManager em = null;
    public Integer affectedRows = 0;

    /*public ResultSet UserEinlesen(String username, String firstname, String lastname) throws Extension {
           }
        MySQLConnection mysqlconn = new MySQLConnection();
        ResultSet res;
        PreparedStatement ps = mysqlconn.conn.prepareStatement("Select * from users where username like ? and firstname like ? and lastname like ?");
        ps.setString(1, username);
        ps.setString(2, firstname);
        ps.setString(3, lastname);
        res=ps.executeQuery();
        return res;
    }*/
/*public void getUserByUserName(String username)throws SQLException{
        MySQLConnection mysqlconn = new MySQLConnection();
        mysqlconn.CreateConnection();*/

public void createEntityManager(){
    emf = Persistence.createEntityManagerFactory( "SmartHomeManager" );
    em = emf.createEntityManager( );
}

public EntityManager getEntityManager(){
    return em;
}

public void BenutzerSuchennachBenutzername(String benutzername){
    if(emf == null || em == null){
        createEntityManager();
    }

    String statement = "select u from User u where u.Username = :username";
    Query query = getEntityManager().createQuery(statement);
    query.setParameter("username", benutzername);

    List<User> UserListe = query.getResultList();

    if(UserListe.isEmpty()){
        System.out.println("Es existiert kein Benutzer mit diesem Benutzernamen!");
    }
    else{
    for (User benutzer : UserListe){
        System.out.println(benutzer.getFirstname() + " " + benutzer.getLastname() + " " + benutzer.getRole() + " " + benutzer.isLoggedIn() + " " + benutzer.getLastTimeLoggedIn() + " " + benutzer.getPassword());
    }
    }
}


    public void getUserByFirstNameAndLastName(String firstname, String lastname) throws Exception{
          // public String getUserByFirstNameAndLastName(String firstname, String lastname)throws SQLException{
           //    MySQLConnection mysqlconn = new MySQLConnection();
            //   mysqlconn.CreateConnection();
       if(emf == null || em == null){
               createEntityManager();
           }

           String statement = "select u from User u where u.Firstame = :vorname AND where u.Lastname = :nachname";
           Query query = getEntityManager().createQuery(statement);
           query.setParameter("vorname", firstname);
           query.setParameter("nachname", lastname);

           List<User> UserListe = query.getResultList();

    if(UserListe.isEmpty()){
               System.out.println("Es existiert kein Benutzer mit diesem Namen!");
           }
    else{
               for (User benutzer : UserListe){
                   System.out.println(benutzer.getId() + " " + benutzer.getUsername()+ " " + benutzer.getFirstname() + " " + benutzer.getLastname() + " " + benutzer.getRole() + " " + benutzer.isLoggedIn() + " " + benutzer.getLastTimeLoggedIn() + " " + benutzer.getPassword());
               }
           }
    }

    /*public ResponseCode logUserIn(User user){
        return logUserIn(user.getUsername());
    }*/

    public ResponseCode logUserIn(Integer userid){

        if(emf == null || em == null){
               createEntityManager();
           }

        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        User u = em.find(User.class, userid);
        u.setLoggedIn(true);
        em.merge(u);
        tx.commit();
        //TODO: check affected rows, etc. --> then return corresponding ResponseObject
        return ResponseCode.LoginSuccessful;
        }


    public ResponseCode logUserOut(Integer userid){
        if(emf == null || em == null){
            createEntityManager();
        }
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        User u =em.find(User.class, userid);
        u.setLoggedIn(false);
        em.merge(u);
        tx.commit();
        //TODO: check affected rows, etc. --> then return corresponding ResponseObject
        return ResponseCode.LogoutSuccessful;
    }

    public List<User> getAllUsers()  {
        if(emf == null || em == null){
            createEntityManager();
        }

        String statement = "select u from User u";
        Query query = getEntityManager().createQuery(statement);

        List<User> UserListe = query.getResultList();

        if(UserListe.isEmpty()){
            System.out.println("Es existiert kein Benutzer!");
            return UserListe;
        }
        else{
            return UserListe;
        }

    }

    public List<User> getAllLoggedInUsers() {
        if(emf == null || em == null){
            createEntityManager();
        }

        String statement = "select u from User u where u.LoggedIn = true";
        Query query = getEntityManager().createQuery(statement);

        List<User> UserListe = query.getResultList();

        if(UserListe.isEmpty()){
            System.out.println("Es existiert kein eingeloggter Benutzer!");
            return UserListe;
        }
        else{
            return UserListe;
        }
    }

    public List<User> getAllLoggedOutUsers() {
        if(emf == null || em == null){
            createEntityManager();
        }

        String statement = "select u from User u where u.LoggedIn = false";
        Query query = getEntityManager().createQuery(statement);

        List<User> UserListe = query.getResultList();

        if(UserListe.isEmpty()){
            System.out.println("Es existiert kein eingeloggter Benutzer!");
            return UserListe;
        }
        else{
            return UserListe;
        }
    }

    public ResponseCode isUserloggedIn(String benutzername) {
        if(emf == null || em == null){
            createEntityManager();
        }

        String statement = "select u from User u where u.Username = :username AND where u.LoggedIn = true";
        Query query = getEntityManager().createQuery(statement);
        query.setParameter("username", benutzername);

        List<User> UserListe = query.getResultList();

        if(UserListe.isEmpty()){
            System.out.println("Es existiert kein Benutzer mit diesem Benutzernamen oder der Benutzer ist nicht eingeloggt!");
            return ResponseCode.Fail;
        }
        else{
            return ResponseCode.LoggedIn;
    }
    }

           public ResponseCode isUserloggedout(String benutzername) {
               if(emf == null || em == null){
                   createEntityManager();
               }

               String statement = "select u from User u where u.Username = :username AND where u.LoggedIn = false";
               Query query = getEntityManager().createQuery(statement);
               query.setParameter("username", benutzername);

               List<User> UserListe = query.getResultList();

               if(UserListe.isEmpty()){
                   System.out.println("Es existiert kein Benutzer mit diesem Benutzernamen oder der Benutzer ist eingeloggt!");
                   return ResponseCode.Fail;
               }
               else{
                   return ResponseCode.LoggedOut;
               }
           }

    public static void main(String args[]) {
        UserDAO benutzerverwaltung = new UserDAO();
        System.out.print(benutzerverwaltung.logUserIn(1));
    }
}


