using DiccionarioMovil.Model;
using DiccionarioMovil.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace DiccionarioMovil
{
    public partial class MainPage : ContentPage
    {

        ApiServices db;

        public MainPage()
        {
            InitializeComponent();
            db = new ApiServices();
            GetListofDictionary();
        }

        private async void GetListofDictionary()
        {

            var response = await ApiServices.ServiceClientInstance.GetDataDiccionario();

            MyList.ItemsSource = response;

        }

        void MyList_Item(Object sender, SelectedItemChangedEventArgs e)
        {
            if (e.SelectedItem == null)
                return;
            var content = e.SelectedItem as Diccionario;
            MyList.SelectedItem = null;

        }

    }
}
