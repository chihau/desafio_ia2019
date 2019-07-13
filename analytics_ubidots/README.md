# Desafío IoT 2018 - 3iE

## Herramientas de Analytics

### Ejemplo para crear un dispositivo que envíe datos de temperatura a Ubidots

* Puedes ejecutar esta aplicación de prueba desde cualquier dispositivo que corre Linux y Python (Raspberry PI, Máquina Virtual, Instancia GCP, etc...)

* Primero debes crear una cuenta Educativa en [Ubidots](https://app.ubidots.com/accounts/signup/)

* Luego tienes iniciar sesión y ir a API Credentials y copiar el Default Token

* Instalar pip
```
sudo apt-get update && sudo apt-get install python-pip
```

* Instalar la biblioteca requests a través de pip
```
pip install requests
```

* Descargar el archivo ubidots_test.py
```
wget https://raw.githubusercontent.com/chihau/desafio_iot2018/master/ubidots/ubidots_test.py
```

* Editar el código en el archivo ubidots_test.py, reemplazando TOKEN_AQUI por el Default Token que generó Ubidots

* Ejecutar la app de prueba
```
python ubidots_test.py
```

* Puedes chequear en la sección Devices si es que aparece tu dispositivo y si es que está capturando datos de la variable temperature

* Luego puedes crear un dashboard para visualizar los datos
