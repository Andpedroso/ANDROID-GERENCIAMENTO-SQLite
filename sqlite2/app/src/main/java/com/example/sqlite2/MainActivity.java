package com.example.sqlite2;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            /*
                                        GERENCIANDO O SQLITE

                           Bem vindo (a)! Este é um app sem interface, foi criado apenas
                           para scprits e comandos necessários para utilizar o SQLite!
                           Utiliza o Logcat para verificar os dados através do SELECT.
                           Consulte aqui o que você precisa para o seu app!

                                        André Moura Pedroso
             */
            //*************************************CRIAR E UTILIZAR O BD************************************************

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //******************************************CRIAR TABELA****************************************************

            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            //*****************************************EXCLUIR TABELA**************************************************

            //bancoDados.execSQL("DROP TABLE pessoas ");

            //*****************************************POPULAR AS TABELAS**********************************************

            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mariana','18') ");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Maria','35') ");

            //*****************************************ATUALIZAR DADOS*************************************************

            //bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva' WHERE nome = 'Mariana' ");
            //bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva' WHERE id = 3 ");

            //*****************************************DELETAR DADOS***************************************************

            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 2 ");
            //bancoDados.execSQL("DELETE FROM pessoas ");

            //***************************************SCRIPTS PARA SELECT***********************************************

            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas " +
                            "WHERE nome = 'Jamilton' " +
                            "AND idade = 30";*/
            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas " +
                            "WHERE idade >= 35 " +
                            "OR idade = 18";*/
            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas " +
                            "WHERE nome " +
                            "IN('Maria', 'Jamilton') ";*/
            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas " +
                            "WHERE idade " +
                            "BETWEEN 30 " +
                            "AND 35 ";*/
            /*String filtro = "mar";
            String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas " +
                            "WHERE nome " +
                            "LIKE '%" + filtro + "%' ";*/
            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas " +
                            "WHERE 1=1 " +
                            "ORDER BY idade ASC ";*/
            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas " +
                            "WHERE 1=1 " +
                            "ORDER BY idade DESC " +
                            "LIMIT 3 ";*/
            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas " +
                            "WHERE 1=1 " +
                            "ORDER BY idade DESC " +
                            "LIMIT 3 ";*/
            String consulta =
                    "SELECT * " +
                            "FROM pessoas " +
                            "WHERE 1=1 ";

            //******************************EXIBINDO DADOS NO LOGCAT UTILIZANDO ÍNDICES*********************************


            Cursor cursor = bancoDados.rawQuery(consulta, null);
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            cursor.moveToFirst();
            while(cursor != null){
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);
                Log.i("RESULTADO - id ", id + ", nome: " + nome + ", idade: " + idade + ".");
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}