
/**
 * 该文件专门用于暴露一个store对象，整个应用只有一个store对象
 */

// 引入createStore，用于创建redux中最为核心的store对象, combineReducers用于合并reducers
import { createStore, applyMiddleware, combineReducers } from 'redux'

// 引入redux-thunk，用于支持异步action
import thunk from 'redux-thunk'

// 引入redux-devtools-extension
import { composeWithDevTools } from 'redux-devtools-extension'

// 引入reducers
import countReducer from './reducers/count'
import personReducer from './reducers/person'

// 汇总reducers
const allReducer = combineReducers({
    count: countReducer,
    persons: personReducer
})

//无异步的情况
// export default createStore(allReducer, composeWithDevTools())

// 有异步的情况
export default createStore(allReducer, composeWithDevTools(applyMiddleware(thunk)))