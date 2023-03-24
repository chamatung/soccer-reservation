import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableRow,
  Paper,
  Button,
} from "@material-ui/core";

const list = [
  {
    id: "02:00",
    name: "성남 야탑 NC백화점 스카이필드 A구장",
    count: "1/18",
    status: "신청",
  },
  {
    id: "04:00",
    name: "서울 영등포 더에프 필드 A구장 *주차마감*",
    count: "16/18",
    status: "마감임박",
  },
  {
    id: "06:00",
    name: "플랩 스타디움 남양주 별내 2구장",
    count: "18/18",
    status: "마감",
  },
];

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

function StadiumList() {
  const classes = useStyles();

  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label='list'>
        <TableBody>
          {list.map((row) => (
            <TableRow key={row.id}>
              <TableCell component='th' scope='row'>
                {row.id}
              </TableCell>
              <TableCell align='center'>{row.name}</TableCell>
              <TableCell align='center'>{row.count}</TableCell>

              <TableCell align='center'>
                <Button style={{ backgroundColor: "red", color: "white" }}>
                  {row.status}
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default StadiumList;
