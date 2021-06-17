using DiccionarioMovil.Model;
using Firebase.Database;
using Firebase.Database.Query;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DiccionarioMovil.Services
{
    class ApiServices
    {
        private static ApiServices _ServiceClientInstance;

        public static ApiServices ServiceClientInstance
        {
            get
            {
                if (_ServiceClientInstance == null)
                    _ServiceClientInstance = new ApiServices();
                return _ServiceClientInstance;
            }
        }

        FirebaseClient firebase;
        public ApiServices()
        {
            firebase = new FirebaseClient("https://diccionariodb-default-rtdb.firebaseio.com/");
        }

        public async Task<bool> registerPalabra(string palabra, string significado)
        {
            var result = await firebase
                .Child("Diccionario")
                .PostAsync(new Diccionario()
                {
                    Palabra = palabra,
                    Significado = significado
                });

            if (result.Object != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public async Task<List<Diccionario>> GetDataDiccionario()
        {
            var GetDatos = (await firebase
                .Child("Diccionario")
                .OnceAsync<Diccionario>()).Select(item => new Diccionario()
                {
                    Palabra = item.Object.Palabra,
                    Significado = item.Object.Significado
                }).ToList();

            return GetDatos;
        }

    }
}
