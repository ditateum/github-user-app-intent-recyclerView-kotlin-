package com.ditateum.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ditateum.githubuserapp.model.GithubUser

class DetailGithubUserActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_GITHUB_USER = "extra_github_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_github_user)

        supportActionBar?.title = "Detail Github User"

        val imgItemAvatar: ImageView = findViewById(R.id.img_item_avatar)
        val tvItemNameUser: TextView = findViewById(R.id.tv_item_name_user)
        val tvItemCompanyUser: TextView = findViewById(R.id.tv_item_company_user)
        val tvItemUsernameUser: TextView = findViewById(R.id.tv_item_username_user)
        val tvItemRepositoryUser: TextView = findViewById(R.id.tv_item_repository_user)
        val tvItemFollowersUser: TextView = findViewById(R.id.tv_item_follower_user)
        val tvItemFollowingUser: TextView = findViewById(R.id.tv_item_following_user)

        val githubUser = intent.getParcelableExtra<GithubUser>(EXTRA_GITHUB_USER) as GithubUser

        imgItemAvatar.setImageResource(githubUser.avatar)
        tvItemNameUser.text = githubUser.name
        tvItemCompanyUser.text = "${githubUser.company} - ${githubUser.location}"
        tvItemUsernameUser.text = "@${githubUser.username}"
        tvItemRepositoryUser.text = "Repository(${githubUser.repository})"
        tvItemFollowersUser.text = "Followers(${githubUser.followers})"
        tvItemFollowingUser.text = "Following(${githubUser.following})"

    }
}