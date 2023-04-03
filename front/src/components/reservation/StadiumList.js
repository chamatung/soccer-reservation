import React, { useEffect } from "react";
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
import { inject, observer } from "mobx-react";

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
});

const StadiumList = inject("reservationStore")(
  observer(({ reservationStore }) => {
    const classes = useStyles();
    const { gameList } = reservationStore;
    console.log(gameList);

    return (
      <TableContainer component={Paper}>
        <Table className={classes.table} aria-label='list'>
          <TableBody>
            {gameList.map((game, index) => (
              <TableRow key={index}>
                <TableCell component='th' scope='row' align='center'>
                  {index + 1}
                </TableCell>

                <TableCell align='center'>{game.name}</TableCell>
                <TableCell align='center'>{game.startTime + " : 00"}</TableCell>
                <TableCell align='center'>
                  {!game.gameApplyCnt
                    ? "0 /" + game.totalMember
                    : game.gameApplyCnt + "/" + game.totalMember}
                </TableCell>
                <TableCell align='center'>
                  <Button style={{ backgroundColor: "red", color: "white" }}>
                    {game.status}
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    );
  })
);
export default StadiumList;
