package com.ditateum.githubuserapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    var name: String,
    var username: String,
    var avatar: Int,
    var location: String,
    var repository: String,
    var company: String,
    var followers: String,
    var following: String,
) : Parcelable
