## SQLite - Android

### Gerenciamento do Banco de Dados Local SQLite
#### Scripts
##### Criar Banco de dados
##### Criar Tabelas
##### Deletar Tabelas
##### Inserir dados
##### Atualizar dados
##### Deletar dados
##### SELECT
##### Exibir dados no Logcat buscando por índices

---

## Utilizando o projeto
#### Basta descomentar o que quer utilizar e rodar o projeto

>CRIAR  e usar o BD
```bash
SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
```

>CRIAR  Tabela
```bash
bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
```

>EXCLUIR  Tabela
```bash
bancoDados.execSQL("DROP TABLE pessoas ");
```

>INSERIR  Dados
```bash
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mariana','18') ");
```

>ATUALIZAR  Dados
```bash
bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva' WHERE nome = 'Mariana' ");
```

>DELETAR  Dados
```bash
bancoDados.execSQL("DELETE FROM pessoas WHERE id = 2 ");
```

>SELECT DE TUDO
```bash
String consulta = "SELECT * " + "FROM pessoas "
```

>EXIBIR no logcat
```bash
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
```

---

## Requisitos
### Android Studio
- [Android Studio](https://developer.android.com/studio?hl=pt&gclid=Cj0KCQjw--2aBhD5ARIsALiRlwCXIlMG00gvVVsxsFc8XHzpwI0TJvaSDogAHrHZ6khceYvWBApD7NAaAp5mEALw_wcB&gclsrc=aw.ds)

---

## Problemas
### Caso rode duas vezes o mesmo comando, o script será executado mais de uma vez podendo duplicar.
### descomente aqpenas o que for utilizar
### o select padrão e a exibição no logcat já estão desomentados e prontos para utilização.