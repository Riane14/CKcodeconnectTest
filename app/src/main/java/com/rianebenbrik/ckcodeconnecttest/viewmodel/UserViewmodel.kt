
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rianebenbrik.ckcodeconnecttest.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewmodel () : ViewModel() {

    private var myrepository: Repository = Repository()
    var usersListLiveData : MutableLiveData<ArrayList<User>?>?=null

    fun fetchAllusers(){
        usersListLiveData  = myrepository?.fetchAllUsers()
      /*  viewModelScope.launch(Dispatchers.IO) {
            usersListLiveData  = myrepository?.fetchAllUsers()
        }*/
    }
}