import React from 'react';
import Cell from './Cell.js';
import { connect } from 'react-redux';
import { updateCell } from '../actions';

const toAttrs = (c, f) =>
  ({ key: c.index.value, value: c.value, index: c.index.value, error: c.error, onChange: v => f(c.index.value, v) })

const row = k => Math.floor(k / 9);
const col = k => k % 9;
const box = k => (Math.floor(k / 27) * 3 + Math.floor((k % 9) / 3));
const eql = (a, b, f) => f(a) === f(b)
const all = (a, b) => eql(a, b, row) || eql(a, b, col) || eql(a, b, box)

const validateCells = function(cells) {
  for (let i = 0; i < 81; i++) {
    let c1 = cells[i];
    c1.error = false;
    for (let j = 0; j < 81; j++) {
      let c2 = cells[j];
      if (i !== j && c1.value === c2.value && all(c1.index.value, c2.index.value)) {
        c1.error = true;
        c2.error = true;
      }
    }
  }
  return cells;
};

const Grid = ({ cells, updateCell }) =>
  (<div className="grid">{validateCells(cells).map(c => (<Cell {...toAttrs(c, updateCell)} />))}</div>)

const mapStateToProps = state => ({
  cells: state.cells,
  activeCell: state.activeCell,
})

export default connect(mapStateToProps, { updateCell })(Grid)
