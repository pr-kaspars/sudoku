import React from 'react';
import ReactDom from 'react-dom';
import Sudoku from './components/Sudoku.js';
import reducer from './reducers';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { getPuzzle } from './actions'
import thunk from 'redux-thunk'

const middleware = [ thunk ];
const store = createStore(reducer, applyMiddleware(...middleware))

store.dispatch(getPuzzle())

ReactDom.render(
  <Provider store={store}>
    <Sudoku/>
  </Provider>,
  document.getElementById('root')
);
