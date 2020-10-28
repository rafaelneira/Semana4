package com.example.appmacostas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.appmacostas.adaptadores.PageAdapter;
import com.example.appmacostas.vista.Fragment_Home;
import com.example.appmacostas.vista.PerfilFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        if (miActionBar != null){
            setSupportActionBar(miActionBar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new Fragment_Home());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.home);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.dog);
    }


    public void irActivityFavoritos (View view){
        Intent intent = new Intent(this, Activity_Favoritos.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mContato:
                Intent intent1 = new Intent(this,ActivityContacto.class);
                startActivity(intent1);
                break;

            case R.id.mAcerca_de:
                Intent intent2 = new Intent(this,ActivityAcercade.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);


    }

}