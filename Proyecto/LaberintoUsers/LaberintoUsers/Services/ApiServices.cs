using Firebase.Database;
using Firebase.Database.Query;
using LaberintoUsers.Table;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LaberintoUsers.Services
{
    class ApiServices
    {

        private JsonSerializer _serializer = new JsonSerializer();

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
            firebase = new FirebaseClient("https://xmazedb-default-rtdb.firebaseio.com/");
        }

        public async Task<bool> registerUser(string username, string password)
        {
            var result = await firebase
                .Child("Usuarios")
                .PostAsync(new Usuario()
                {
                    UserName = username,
                    Password = password
                });

            if (result.Object != null)
            {
                return true;
            } else
            {
                return false;
            }
        }

        public async Task<List<Usuario>> GetRegisteredUsers()
        {
            var GetClients = (await firebase
                .Child("Usuarios")
                .OnceAsync<Usuario>()).Select(item => new Usuario()
                {
                    UserName = item.Object.UserName,
                    Password = item.Object.Password
                }).ToList();

            return GetClients;
        }

    }
}