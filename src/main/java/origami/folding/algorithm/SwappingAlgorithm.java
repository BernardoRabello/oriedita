package origami.folding.algorithm;

import java.util.*;

import origami.folding.element.SubFace;

/**
 * Author: Mu-Tsun Tsai
 * 
 * The original Orihime algorithm chooses an initial SubFace ordering to perform
 * the exhaustive search, but it is very commonly the case that the ordering is
 * not optimal, leading to a phenomenon where the search reaches the same
 * dead-end at a certain depth over and over. The idea of swapping algorithm is
 * to swap the order of the SubFace reaching a dead-end to a earlier position,
 * and doing so generally improves ths searching performance.
 * 
 * One problem that may arises with the swapping algorithm is looping, where two
 * or more SubFaces swap in a loop (and possibly reset each other during the
 * process). In order to prevent this, the swapping algorithm now implements a
 * hash table recording the visited SubFace sequence. If the same sequence
 * reappears and swapping is again requested, it will introduce an unvisited
 * SubFace to the game to spice things up. This has proven to be quite effective
 * in breaking the loop.
 */
public class SwappingAlgorithm {

    private int high;
    private int lastLow;

    // For preventing cycling swapping over and over.
    private final Set<Long> history = new HashSet<>();
    private final Set<Integer> visited = new HashSet<>();

    /** Records a dead-end. */
    public void record(int value) {
        high = value;
    }

    /** Performs the swap. */
    public void process(SubFace[] s) {
        if (high == 0) return;

        long hash = getHash(s, high);
        if (history.contains(hash)) {
            // Introduce an unvisited SubFace to the game.
            boolean found = false;
            for (int i = 1; i < s.length && !found; i++) {
                if (!visited.contains(s[i].id)) {
                    swap(s, i, 1);
                    hash = getHash(s, ++high);
                    found = true;
                }
            }
            if (!found) return; // Let's hope that this never happen, or we're out of tricks.
        }
        history.add(hash);

        // Perform swap
        int low = high / 2;
        swap(s, high, low);
        lastLow = low;
        high = 0;
    }

    private long getHash(SubFace[] s, int high) {
        int[] ids = new int[high];
        for (int i = 0; i < high; i++) {
            ids[i] = s[i + 1].id;
        }
        return Arrays.hashCode(ids);
    }

    public boolean shouldEstimate(int s) {
        if (lastLow == 0) return true;
        if (s == lastLow) {
            lastLow = 0;
            return true;
        }
        return false;
    }

    public void swap(SubFace[] s, int high, int low) {
        System.out.println("swapper.swap(s, " + high + ", " + low + ");");
        SubFace temp = s[high];
        for (int i = high; i > low; i--) {
            s[i] = s[i - 1];
            s[i].clearTempGuide();
        }
        s[low] = temp;
    }

    public void reverseSwap(SubFace[] s, int high, int low) {
        SubFace temp = s[low];
        for (int i = low; i < high; i++) {
            s[i] = s[i + 1];
        }
        s[high] = temp;
    }

    public void visit(SubFace s) {
        visited.add(s.id);
    }
}
