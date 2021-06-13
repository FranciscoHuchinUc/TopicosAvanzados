
using LaberintoUsers.Services;
using LaberintoUsers.Table;
using System;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace LaberintoUsers
{
    public partial class MainPage : ContentPage
    {

        ApiServices db;

        public MainPage()
        {
            InitializeComponent();
            db = new ApiServices();
            GetListofClients();
        }

        private async void GetListofClients()
        {

            var response = await ApiServices.ServiceClientInstance.GetRegisteredUsers();

            MyList.ItemsSource = response;

        }

        void MyList_ItemSelected(Object sender, SelectedItemChangedEventArgs e)
        {
            if (e.SelectedItem == null)
                return;
            var content = e.SelectedItem as Usuario;
            MyList.SelectedItem = null;

        }

        async private void RefreshView_Refreshing(object sender, EventArgs e)
        {
            await Task.Delay(1500);
            GetListofClients();
            MyRefreshView.IsRefreshing = false;
            MyList.IsRefreshing = false;
        }
    }
}
