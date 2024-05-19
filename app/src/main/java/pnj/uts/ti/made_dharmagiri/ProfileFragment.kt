import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import pnj.uts.ti.made_dharmagiri.MainActivity
import pnj.uts.ti.made_dharmagiri.R

class ProfileFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_profile, container, false)

        sharedPreferences = requireContext().getSharedPreferences("UserData", Context.MODE_PRIVATE)

        val tvEmail: TextView = view.findViewById(R.id.tv_email)
        val tvNim: TextView = view.findViewById(R.id.tv_nim)
        val tvNama: TextView = view.findViewById(R.id.tv_nama)
        val tvKelas: TextView = view.findViewById(R.id.tv_kelas)

        val email = sharedPreferences.getString("Email", "")
        val nim = sharedPreferences.getString("Nim", "")
        val nama = sharedPreferences.getString("Nama", "")
        val kelas = sharedPreferences.getString("Kelas", "")

        tvEmail.text = "Email: $email"
        tvNim.text = "NIM: $nim"
        tvNama.text = "Nama: $nama"
        tvKelas.text = "Kelas: $kelas"

        val btnLogout: Button = view.findViewById(R.id.btn_logout)

        btnLogout.setOnClickListener {
            sharedPreferences.edit().clear().apply()

            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}
