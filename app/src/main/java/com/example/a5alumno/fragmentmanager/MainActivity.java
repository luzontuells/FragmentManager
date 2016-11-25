package com.example.a5alumno.fragmentmanager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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


public class MainActivity extends AppCompatActivity implements View.OnClickListener, FirstFragment.OnFirstFragmentInterface {

    private boolean mTwoPane;
    private LinearLayout land_LinLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mTwoPane = findViewById(R.id.frameLayoutMainLandscape) == null;
        if (!mTwoPane) {

            //FragmentManager fragmentManager = this.getFragmentManager();

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayoutMainLandscape, new FirstFragment(), this.getString(R.string.first_fragment_tag));
            //            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            final Button swapFragment_Btn = (Button) this.findViewById(R.id.btnSwapFragment);
            swapFragment_Btn.setOnClickListener(this);

            this.land_LinLayout = (LinearLayout) this.findViewById(R.id.linearLayoutMainLandscape);
            this.land_LinLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));

        }

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSwapFragment) {
            if (findViewById(R.id.firstFragmentButton)==null){
                //Cambiar a FirstFragment
                FragmentManager fragmentManager = this.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayoutMainLandscape, new FirstFragment(), this.getString(R.string.first_fragment_tag));
                fragmentTransaction.commit();
            } else {
                //Cambiar a SecondFragment
                FragmentManager fragmentManager = this.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayoutMainLandscape, new SecondFragment(), this.getString(R.string.second_fragment_tag));
                fragmentTransaction.commit();
            }
        }
    }


    @Override
    public void onCommFromFragmentOne(long rNumber) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.fragmentSecond);
        secondFragment.updateTextInfo(String.valueOf(rNumber));
    }
}
