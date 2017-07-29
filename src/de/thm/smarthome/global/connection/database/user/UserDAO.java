package de.thm.smarthome.global.connection.database.user;
import de.thm.smarthome.global.beans.MessageBean;
import de.thm.smarthome.global.enumeration.EMessageCode;

import javax.persistence.*;
import java.util.List;

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

    //TODO: Prüfung, ob Nutzerliste hier sinnvoll /notwendig ist

    if(UserListe.isEmpty()){
        new MessageBean(EMessageCode.FAIL);
        /*System.out.println("Es existiert kein Benutzer mit diesem Benutzernamen!");*/
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
        new MessageBean(EMessageCode.FAIL);
        /*System.out.println("Es existiert kein Benutzer mit diesem Namen!");*/
           }
    else{
               for (User benutzer : UserListe){
                   System.out.println(benutzer.getId() + " " + benutzer.getUsername()+ " " + benutzer.getFirstname() + " " + benutzer.getLastname() + " " + benutzer.getRole() + " " + benutzer.isLoggedIn() + " " + benutzer.getLastTimeLoggedIn() + " " + benutzer.getPassword());
               }
           }
    }

    /*public EMessageCode logUserIn(User user){
        return logUserIn(user.getUsername());
    }*/

    public MessageBean logUserIn(String username, String password){

        if(emf == null || em == null){
               createEntityManager();
           }

        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        User u = em.find(User.class, username);
        u.setLoggedIn(true);
        em.merge(u);
        tx.commit();
        //TODO: check affected rows, etc. --> then return corresponding ResponseObject
        return new MessageBean(EMessageCode.SUCCESS);
        }



           public MessageBean logUserOut(String username){
        if(emf == null || em == null){
            createEntityManager();
        }
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();
        User u =em.find(User.class, username);
        u.setLoggedIn(false);
        em.merge(u);
        tx.commit();
        //TODO: check affected rows, etc. --> then return corresponding ResponseObject
        return new MessageBean(EMessageCode.SUCCESS);
    }

    public List<User> getAllUsers()  {
        if(emf == null || em == null){
            createEntityManager();
        }

        String statement = "select u from User u";
        Query query = getEntityManager().createQuery(statement);

        List<User> UserListe = query.getResultList();

        if(UserListe.isEmpty()){
            new MessageBean(EMessageCode.FAIL);
            // System.out.println("Es existiert kein Benutzer!");
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
            /*System.out.println("Es existiert kein eingeloggter Benutzer!");*/

            new MessageBean(EMessageCode.FAIL);
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
            /* System.out.println("Es existiert kein eingeloggter Benutzer!"); */
            new MessageBean(EMessageCode.FAIL);
            return UserListe;
        }
        else{
            return UserListe;
        }
    }

    public MessageBean isUserloggedIn(String benutzername) {
        if(emf == null || em == null){
            createEntityManager();
        }

        String statement = "select u from User u where u.Username = :username AND where u.LoggedIn = true";
        Query query = getEntityManager().createQuery(statement);
        query.setParameter("username", benutzername);

        List<User> UserListe = query.getResultList();

        if(UserListe.isEmpty()){
            //System.out.println("Es existiert kein Benutzer mit diesem Benutzernamen oder der Benutzer ist nicht eingeloggt!");
            return new MessageBean(EMessageCode.NOTLOGGEDIN);
        }
        else{
            return new MessageBean(EMessageCode.LOGGEDIN);
    }
    }

   public MessageBean isUserloggedout(String benutzername) {
       return isUserloggedIn(benutzername); // does same!
   }
}


