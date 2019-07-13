# Desafío IA 2019 \- 3iE

## Herramientas de Analytics

### Análisis y Visualización de datos con Hojas de Cálculo
- Descarga el archivo [Cities.csv](https://raw.githubusercontent.com/chihau/desafio_iot2018/master/analytics/google_sheets/Cities.csv)

### Análisis y Visualización de datos con Python
- [Jupyter Notebooks](https://mybinder.org/v2/gh/chihau/desafio_ia2019/master)

### Bigquery
- Ir a la [Console de Bigquery](http://bigquery.cloud.google.com/)

- Vamos a consultar la cantidad de personas con el nombre 'Mary' existen en USA desde 1910
```
SELECT SUM(number) AS TOTAL_MARY 
FROM [bigquery-public-data.usa_names.usa_1910_current] 
WHERE name = 'Mary'
```

- Vamos a consultar cuál es el asunto más utilizado para un commit en github
```
SELECT subject AS subject,
  COUNT(*) AS num_duplicates
FROM [bigquery-public-data.github_repos.commits]
GROUP BY subject
ORDER BY num_duplicates DESC
LIMIT 100
```
