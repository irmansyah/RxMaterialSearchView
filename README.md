# RxMaterialSearchView
this library rxjava2 version from material search view https://github.com/MiguelCatalan/MaterialSearchView

# Usage
**Add the dependencies to your gradle file:**
```javascript
	dependencies {
    		implementation 'com.github.irmansyah:RxMaterialSearchView:v1.0.0'
		
		// reactive
    		implementation "io.reactivex.rxjava2:rxjava:$rootProject.rxjava2Version"
    		implementation "io.reactivex.rxjava2:rxandroid:$rootProject.rxandroidVersion"
	}
```
**Add maven:**
```javascript
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
**Add MaterialSearchView to your layout file along with the Toolbar** *(Add this block at the bottom of your layout, in order to display it over the rest of the view)*:

```xml
    <!— Must be last for right layering display —>
    <FrameLayout
        android:id="@+id/toolbar_container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="@color/theme_primary" />

        <com.irmansyah.rxmaterialsearchview.RxMaterialSearchView
            android:id="@+id/search_view"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </FrameLayout>
```
**Add the search item into the menu file:**
```xml
	<item
        android:id="@+id/action_search"
        android:icon="@drawable/ic_action_action_search"
        android:orderInCategory="100"
        android:title="@string/abc_search_hint"
        app:showAsAction="always" />
```
**Add define it in the *onCreateOptionsMenu*:**
```kotlin
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater?.inflate(R.menu.menu_team, menu)
        val item = menu?.findItem(R.id.action_search)
        search_view.setMenuItem(item)
        setSearchView()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.action_search -> {
                search_view.showSearch()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
```
**How to use:**
```kotlin
	fun setSearchView() {
	    search_view.showSearch()
	    compositeDisposable.add(search_view.createObservable()
		.subscribeOn(Schedulers.io())
		.observeOn(AndroidSchedulers.mainThread())
		.subscribe {

		    Log.i("MainActivity", "Searchview : $it")

		})

	}    
```
