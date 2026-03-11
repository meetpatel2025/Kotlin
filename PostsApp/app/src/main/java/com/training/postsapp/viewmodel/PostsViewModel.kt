package com.training.postsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.postsapp.model.Post
import com.training.postsapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    val posts = MutableLiveData<List<Post>>()

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val data = repository.getPosts()
                posts.postValue(data)
            }catch (e: Exception){
                posts.postValue(emptyList())
            }
        }
    }
}