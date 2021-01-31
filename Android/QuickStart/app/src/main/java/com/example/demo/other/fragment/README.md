### Fragment
1. `Fragment`有自己的生命周期
2. `Fragment`依赖于`Activity`
3. `Fragment`通过`getActivity()`可以获取所在的`Activity`;`Activity`通过`FragmentManager`的`findFragmentById()`或`findFragmentByTag()`获取`Fragment`
4. `Fragment`和`Activity`是多对多的关系