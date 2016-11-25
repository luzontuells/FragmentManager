package com.example.a5alumno.fragmentmanager;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
La aplicación a implementar consta de dos Fragments que se utilizan de forma distinta en función del modo
de visualización: en modo portrait se muestran uno encima de otro, mientras que en modo landscape solo
uno se ve en pantalla.
- Modo portrait. Ambos Fragments se añaden “estáticamente” al layout. Al accionar el botón del
Fragment superior, un número aleatorio es generado y mostrado en el Fragment inferior.
- Modo landscape. Los Fragments se añaden alternativamente y de forma dinámica al layout cuando
el usuario pulsa sobre el botón “Swap fragment”. El botón del Fragment superior sigue teniendo la
misma funcionalidad, por lo que al ser accionado en este modo provocará que se añada el segundo
Fragment y que éste muestre un número aleatorio.
El desarrollador debe comprobar el correcto funcionamiento de la aplicación en los diferentes modos de
visualización. Para ello, deberá emplear un terminal físico o hacer uso de la funcionalidad “rotar pantalla”
disponible en el emulador.
 */


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FragmentManager fragmentManager = this.getFragmentManager();

    }


    @Override
    public void onClick(View view) {

    }
}
