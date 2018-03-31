package com.github.papered.a15th_appzam.Activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.papered.a15th_appzam.R
import kotlinx.android.synthetic.main.activity_set_profile.*
import android.widget.Toast
import com.github.papered.a15th_appzam.Connect.Connector
import com.github.papered.a15th_appzam.Util
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SetProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_profile)

        startActivity(Intent(this, ContentActivity::class.java))

        setProfile_img_profile.background = ShapeDrawable(OvalShape())
        setProfile_img_profile.clipToOutline = true

        val permissionListener = object : PermissionListener {
            override fun onPermissionGranted() {
                Toast.makeText(baseContext, "권한 허가", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(deniedPermissions: ArrayList<String>) {
                Toast.makeText(baseContext, "권한 거부\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show()
            }

        }

        setProfile_btn_addImg.setOnClickListener {
            TedPermission.with(this)
                    .setPermissionListener(permissionListener)
                    .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                    .setPermissions(Manifest.permission.CAMERA)
                    .check()

            val intent = Intent(Intent.ACTION_PICK)
            intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            intent.type = "image/*"
            startActivityForResult(intent, 1112)
        }

        setProfile_btn_submit.setOnClickListener {
            Connector.api.setProfile(Authorization = Util.getToken(baseContext), nickname = setProfile_edit_nickname.text.toString(), description = setProfile_edit_description.text.toString())
                    .enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                            Toast.makeText(baseContext, "성공", Toast.LENGTH_SHORT).show()
                        }

                        override fun onFailure(call: Call<Void>?, t: Throwable?) {

                        }

                    })
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            val image = data!!.data
            setProfile_img_profile.setImageURI(image)
        }
    }
}
