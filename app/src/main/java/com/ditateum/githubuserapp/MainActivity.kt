package com.ditateum.githubuserapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ditateum.githubuserapp.adapter.ListGithubUserAdapater
import com.ditateum.githubuserapp.model.GithubUser

class MainActivity : AppCompatActivity() {
    private lateinit var rvGithubUsers: RecyclerView
    private val list = ArrayList<GithubUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Github User's"

        rvGithubUsers = findViewById(R.id.rv_github_users)
        rvGithubUsers.setHasFixedSize(true)

        list.addAll(listGithubUsers)
        showRecyclerList()
    }

    private val listGithubUsers: ArrayList<GithubUser>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)

            val listGithubUser = arrayListOf<GithubUser>()
            for (i in dataName.indices) {
                val githubUser = GithubUser(dataName[i],
                                            dataUsername[i],
                                            dataAvatar.getResourceId(i, -1),
                                            dataLocation[i],
                                            dataRepository[i],
                                            dataCompany[i],
                                            dataFollowers[i],
                                            dataFollowing[i])
                listGithubUser.add(githubUser)
            }

            return listGithubUser
        }

    private fun showSelectedUserDetail(githubUser: GithubUser) {
        val detailUserGithubIntent = Intent(this, DetailGithubUserActivity::class.java)
        detailUserGithubIntent.putExtra(DetailGithubUserActivity.EXTRA_GITHUB_USER, githubUser)
        startActivity(detailUserGithubIntent)
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvGithubUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvGithubUsers.layoutManager = LinearLayoutManager(this)
        }

        val listGithubUserAdapter = ListGithubUserAdapater(list)
        rvGithubUsers.adapter = listGithubUserAdapter

        listGithubUserAdapter.setOnItemClickCallback(object : ListGithubUserAdapater.OnItemClickCallback {
            override fun onItemClicked(data: GithubUser) {
                showSelectedUserDetail(data)
            }
        })
    }


}