package com.irmansyah.rxmaterialsearchview

import android.content.Context
import android.support.v7.widget.SearchView
import android.util.AttributeSet
import com.miguelcatalan.materialsearchview.MaterialSearchView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

//class RxMaterialSearchView {
//
//    companion object {
//
//        fun fromView(searchView: RxMaterialSearchView): Observable<String> {
//            val publishSubject = PublishSubject.create<String>()
//            searchView.setQu(object : SearchView.OnQueryTextListener {
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    publishSubject.onComplete()
//                    return true
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//                    publishSubject.onNext(newText)
//                    return true
//                }
//
//            })
//            return publishSubject
//        }
//    }
//}

class RxMaterialSearchView  : MaterialSearchView {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    fun createObservable(): Observable<String> {
        val publishSubject = PublishSubject.create<String>()
        this.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                publishSubject.onComplete()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                publishSubject.onNext(newText)
                return true
            }

        })
        return publishSubject
    }
}