using EjercicioParcial2.Services;
using EjercicioParcial2.Views;
using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace EjercicioParcial2
{
    public partial class App : Application
    {

        public App()
        {
            InitializeComponent();

            DependencyService.Register<MockDataStore>();
            MainPage = new AppShell();
        }

        protected override void OnStart()
        {
        }

        protected override void OnSleep()
        {
        }

        protected override void OnResume()
        {
        }
    }
}
