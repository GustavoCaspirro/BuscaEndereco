package br.com.caspirro.fiap.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import br.com.caspirro.fiap.R
import br.com.caspirro.fiap.base.BaseActivity
import br.com.caspirro.fiap.databinding.ActivityMainBinding
import br.com.caspirro.fiap.model.Endereco
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainView {
    override fun instantiatePresenter(): MainPresenter {
        return MainPresenter(this)
    }
    override fun atualizaEndereco(endereco: Endereco) {
        Toast.makeText(this, endereco.logradouro, Toast.LENGTH_SHORT).show()
        tvLogradouro.text = endereco.logradouro
        tvBairro.text = endereco.bairro
        tvUF.text = endereco.uf
    }
    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = View.GONE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        binding.presenter = presenter
    }
}

