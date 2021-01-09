// 引入Count的UI组件
import CountUI from '../../components/Count'

// 引入action
import { 
    createIncrementAction, 
    createIncrementAsyncAction, 
    createDecrementAction 
} from "../../redux/count_action";

// 引入connect用于连接UI组件与redux
import {connect} from 'react-redux'

// mapStateToProps函数的返回的是一个对象
// 对象中的key就作为传递给UI组件props的key，value就作为传递给UI组件props的value——状态
// mapStateToProps用于传递状态
function mapStateToProps(state) {
    return {count: state}
}

// mapDispatchToProps函数的返回的是一个对象
// 对象中的key就作为传递给UI组件props的key，value就作为传递给UI组件props的value——操作状态的方法
// mapDispatchToProps用于传递操作状态的方法
function mapDispatchToProps(dispatch) {
    return {
        increment: (data)=> {
            // 通知redux执行加法
            dispatch(createIncrementAction(data))
        },
        decrement: (data) => {
            dispatch(createDecrementAction(data))
        },
        incrementAsync: (data, time) => {
            dispatch(createIncrementAsyncAction(data, time))
        }
    }
}

// 创建并暴露一个Count组件
export default connect(mapStateToProps, mapDispatchToProps)(CountUI)
