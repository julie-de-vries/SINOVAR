/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nf;

/**
 *
 * @author Julie
 */


import java.sql.*;
import java.util.ArrayList;

public class DataBaseLayer {
    private ArrayList<ArrayList<String>> result=new ArrayList<>();
    private int modification;

    public DataBaseLayer(String requete){
       //Récupération des données SQL
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* Gérer les éventuelles erreurs ici. */
            e.printStackTrace();
        }
        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/sinovar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "Julie";
        String password = "sinovAr4";
        Connection connexion = null;
       try {
           connexion = DriverManager.getConnection( url ,user, password);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       Statement statement = null;
       try {
           statement = connexion.createStatement();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       try {
            /* Création de l'objet gérant les requêtes */
            /* Exécution d'une requête de lecture */
            if (requete.startsWith("SELECT")){
                /*selon si la requête est une lecture ou une modification*/
                ResultSet resultSet = statement.executeQuery( requete );
                //String nom = result.getString(TABLE_USERS_NAME_COLUMN_NAME);
                //int i=0;
                //while (resultSet.next()){
                    //result.add(resultSet.get);
                    //i++;
                //}
                result=resultSetToArrayList(resultSet);
            
            }
            else{
                modification = statement.executeUpdate ( requete ); 
                /*vaut soit le nombre de colonnes resultat ou 0 si il n'y pas de resultat*/ 
            }
        } catch ( SQLException e ) {
            /* Gérer les éventuelles erreurs ici */
            System.out.println("pas de connexion");
            e.printStackTrace();
        } finally {
            if ( connexion != null )
                try {
                    /* Fermeture de la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
                    /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                }
        }
   }

    /**
     * @return the resultat
     */
    public ArrayList<ArrayList<String>> getResult() {
        return result;
    }

    /**
     * @return the modification
     */
    public int getModification() {
        return modification;
    }
    
    ArrayList<ArrayList<String>> resultSetToArrayList(ResultSet row) throws SQLException{
    ResultSetMetaData meta= row.getMetaData();
    int length=meta.getColumnCount();
    ArrayList<ArrayList<String>> model=new ArrayList<>();
    ArrayList<String> columnLabels = new ArrayList<>();
    for(int i=0;i<length;++i){
        columnLabels.add(meta.getColumnLabel(i+1));
    }
    model.add(columnLabels);

    while(row.next()){
        ArrayList<String> rowList = new ArrayList<>();
        for(int i=0;i<length;++i)
             {
             rowList.add(row.getString(i+1));
             }
        model.add(rowList);
    }
    return model;
    }
    
    
}